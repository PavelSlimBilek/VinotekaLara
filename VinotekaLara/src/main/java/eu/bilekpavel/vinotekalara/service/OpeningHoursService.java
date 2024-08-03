package eu.bilekpavel.vinotekalara.service;

import eu.bilekpavel.vinotekalara.dto.OpeningHours;
import eu.bilekpavel.vinotekalara.dto.OpeningHoursRequest;
import eu.bilekpavel.vinotekalara.repository.OpeningHoursRepositoryInterface;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@EnableScheduling
public class OpeningHoursService implements OpeningHoursServiceInterface {

    private final OpeningHoursRepositoryInterface repo;
    private final Map<DayOfWeek, OpeningHours> cachedOpeningHours;

    public OpeningHoursService(OpeningHoursRepositoryInterface repo) {
        this.repo = repo;
        this.cachedOpeningHours = new HashMap<>();
    }

    @Scheduled(fixedRate = 20_000)
    public void updateHours() {
        cachedOpeningHours.clear();
        try {
            for (OpeningHours hours : repo.getAll()) {
                cachedOpeningHours.put(hours.getDay(), hours);
            }
        } catch (Exception e) {

        }
    }

    @Override
    public OpeningHours getTodayHours() {
        DayOfWeek today = LocalDate.now().getDayOfWeek();
        return cachedOpeningHours.get(today);
    }

    @Override
    public boolean save(OpeningHoursRequest request) {
        OpeningHours openingHours;
        try {
            openingHours = new OpeningHours(request);
        } catch (Exception e) {
            return false;
        }
        return this.repo.save(openingHours);
    }

    @Override
    public List<OpeningHours> getOpeningHours() {
        return this.cachedOpeningHours.values().stream().toList();
    }

    @Override
    public boolean isOpened() {
        return false;
    }


}
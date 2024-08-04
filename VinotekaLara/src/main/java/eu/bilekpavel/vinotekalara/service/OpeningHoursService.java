package eu.bilekpavel.vinotekalara.service;

import eu.bilekpavel.vinotekalara.dto.OpeningHours;
import eu.bilekpavel.vinotekalara.dto.OpeningHoursRequest;
import eu.bilekpavel.vinotekalara.repository.OpeningHoursRepositoryInterface;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
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
            System.out.println("updateHours failed");
        }
    }

    @Override
    public OpeningHours getTodayHours() {
        DayOfWeek today = LocalDate.now().getDayOfWeek();
        return cachedOpeningHours.get(today);
    }

    @Override
    public void save(OpeningHoursRequest request) throws Exception {
        OpeningHours openingHours;
        openingHours = new OpeningHours(request);
        this.repo.save(openingHours);
    }

    @Override
    public List<OpeningHours> getOpeningHours() {
        return this.cachedOpeningHours.values().stream().toList();
    }

    @Override
    public boolean isOpened() {

        DayOfWeek today = LocalDate.now().getDayOfWeek();
        Time now = Time.valueOf(LocalTime.now());

        OpeningHours todayHours = cachedOpeningHours.get(today);
        if (todayHours == null) {
            return false;
        }

        Time start = todayHours.getHours().start();
        Time end = todayHours.getHours().end();

        return (now.after(start) || now.equals(start)) && now.before(end);
    }
}
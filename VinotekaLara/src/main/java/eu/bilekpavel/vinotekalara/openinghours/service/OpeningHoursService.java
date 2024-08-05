package eu.bilekpavel.vinotekalara.openinghours.service;

import eu.bilekpavel.vinotekalara.config.AppSettings;
import eu.bilekpavel.vinotekalara.openinghours.dto.OpeningHours;
import eu.bilekpavel.vinotekalara.openinghours.dto.OpeningHoursRequest;
import eu.bilekpavel.vinotekalara.openinghours.repository.OpeningHoursRepositoryInterface;
import eu.bilekpavel.vinotekalara.translator.TranslatorInterface;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@EnableScheduling
public class OpeningHoursService implements OpeningHoursServiceInterface {

    private final OpeningHoursRepositoryInterface repo;
    private final List<OpeningHours> cachedOpeningHours;

    public OpeningHoursService(
        OpeningHoursRepositoryInterface repo
    ) {
        this.repo = repo;
        this.cachedOpeningHours = new ArrayList<>();
        updateHours();
    }

    @Scheduled(fixedRate = 20_000)
    public void updateHours() {
        cachedOpeningHours.clear();
        cachedOpeningHours.addAll(repo.getAll());
    }

    @Override
    public OpeningHours getTodayHours() {
        DayOfWeek today = LocalDate.now().getDayOfWeek();
        return cachedOpeningHours.stream()
                .filter((hours) -> hours.getDay() == today)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<String> getTransformedOpeningHours(TranslatorInterface transformer) {
        return transformer.transformAll(getCachedOpeningHours());
    }

    @Override
    public String getTransformedTodayHours(TranslatorInterface transformer) {
        return transformer.transform(getTodayHours());
    }

    @Override
    public String getOpenedMessage(TranslatorInterface transformer) {
        return transformer.isOpenedMessage(isOpened());
    }

    @Override
    public void save(OpeningHoursRequest request) throws Exception {
        OpeningHours openingHours;
        openingHours = new OpeningHours(request);
        this.repo.save(openingHours);
    }

    @Override
    public List<OpeningHours> getCachedOpeningHours() {
        return this.cachedOpeningHours;
    }

    @Override
    public boolean isOpened() {

        Time now = Time.valueOf(LocalTime.now());
        OpeningHours todayHours = getTodayHours();
        if (todayHours == null) {
            return false;
        }

        Time morningStart = todayHours.getMorningHours().start();
        Time morningEnd = todayHours.getMorningHours().end();

        if (!AppSettings.areAfternoonHoursAllowed || todayHours.getAfternoonHours() == null) {
            return (now.after(morningStart) || now.equals(morningStart)) && now.before(morningEnd);
        }
        Time afternoonStart = todayHours.getAfternoonHours().start();
        Time afternoonEnd = todayHours.getAfternoonHours().end();

        return ((now.after(morningStart) || now.equals(morningStart)) && now.before(morningEnd)) ||
                (now.after(afternoonStart) || now.equals(afternoonStart) && now.before(afternoonEnd));
    }
}
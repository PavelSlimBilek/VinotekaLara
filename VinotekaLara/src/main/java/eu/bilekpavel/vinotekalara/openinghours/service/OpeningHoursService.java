package eu.bilekpavel.vinotekalara.openinghours.service;

import eu.bilekpavel.vinotekalara.app.AppSettings;
import eu.bilekpavel.vinotekalara.openinghours.dto.TranslatedOpeningHoursData;
import eu.bilekpavel.vinotekalara.openinghours.model.OpeningHours;
import eu.bilekpavel.vinotekalara.openinghours.dto.OpeningHoursRequest;
import eu.bilekpavel.vinotekalara.openinghours.repository.OpeningHoursRepositoryInterface;
import eu.bilekpavel.vinotekalara.openinghours.translator.OpeningHoursTranslatorInterface;
import eu.bilekpavel.vinotekalara.openinghours.translator.dto.TranslatedDayOfWeek;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
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
    public List<String> getTranslatedOpeningHours(OpeningHoursTranslatorInterface transformer) {
        return transformer.transformAll(getCachedOpeningHours());
    }

    @Override
    public String getTranslatedTodayHours(OpeningHoursTranslatorInterface transformer) {
        return transformer.transform(getTodayHours());
    }

    @Override
    public String getTranslatedOpenedMessage(OpeningHoursTranslatorInterface transformer) {
        return transformer.getIsOpenedMessage(isOpened());
    }

    @Override
    public List<TranslatedDayOfWeek> getTranslatedDaysOfWeek(OpeningHoursTranslatorInterface translator) {
        return List.of(
                new TranslatedDayOfWeek(DayOfWeek.MONDAY.getValue(), translator.getMonday()),
                new TranslatedDayOfWeek(DayOfWeek.TUESDAY.getValue(), translator.getTuesday()),
                new TranslatedDayOfWeek(DayOfWeek.WEDNESDAY.getValue(), translator.getWednesday()),
                new TranslatedDayOfWeek(DayOfWeek.THURSDAY.getValue(), translator.getThursday()),
                new TranslatedDayOfWeek(DayOfWeek.FRIDAY.getValue(), translator.getFriday()),
                new TranslatedDayOfWeek(DayOfWeek.SATURDAY.getValue(), translator.getSaturday()),
                new TranslatedDayOfWeek(DayOfWeek.SUNDAY.getValue(), translator.getSunday())
        );
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

    @Override
    public TranslatedOpeningHoursData getTranslatedData(OpeningHoursTranslatorInterface translator) {
        return new TranslatedOpeningHoursData(
                translator.getDay(),
                translator.getStart(),
                translator.getEnd(),
                translator.getMorningHours(),
                translator.getAfternoonHours(),
                translator.getOpeningHours(),
                getTranslatedDaysOfWeek(translator),
                getTranslatedOpeningHours(translator),
                getTranslatedTodayHours(translator),
                getTranslatedOpenedMessage(translator)
        );
    }
}
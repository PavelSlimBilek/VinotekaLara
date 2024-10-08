package eu.bilekpavel.vinotekalara.openinghours.service;

import eu.bilekpavel.vinotekalara.openinghours.dto.DailyHours;
import eu.bilekpavel.vinotekalara.openinghours.dto.LocalizedOpeningHours;
import eu.bilekpavel.vinotekalara.openinghours.dto.WeeklyHoursData;
import eu.bilekpavel.vinotekalara.openinghours.model.WeeklyHours;
import eu.bilekpavel.vinotekalara.openinghours.repository.WeeklyHoursRepositoryInterface;
import eu.bilekpavel.vinotekalara.openinghours.translator.OpeningHoursTranslatorInterface;
import eu.bilekpavel.vinotekalara.openinghours.translator.dto.LocalizedDayOfWeek;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class WeeklyHoursService implements WeeklyHoursServiceInterface {

    private final WeeklyHoursRepositoryInterface repo;
    private WeeklyHours currentGlobalHours;

    public WeeklyHoursService(
            @Qualifier("hours_db_repository") WeeklyHoursRepositoryInterface repo
    ) {
        this.repo = repo;
        currentGlobalHours = repo.findById(1);
    }

    @Override
    public boolean save(WeeklyHours hours) {
        return null != repo.save(hours);
    }

    @Override
    public WeeklyHoursData get() {
        return new WeeklyHoursData(
                currentGlobalHours.getId(),
                currentGlobalHours.getUserIdentifier(),
                currentGlobalHours.getMonday(),
                currentGlobalHours.getTuesday(),
                currentGlobalHours.getWednesday(),
                currentGlobalHours.getThursday(),
                currentGlobalHours.getFriday(),
                currentGlobalHours.getSaturday(),
                currentGlobalHours.getSunday()
        );
    }

    @Override
    public WeeklyHoursData get(int id) {
        WeeklyHours hours = repo.findById(id);

        if (hours == null) {
            return null;
        }

        return new WeeklyHoursData(
                id,
                hours.getUserIdentifier(),
                hours.getMonday(),
                hours.getTuesday(),
                hours.getWednesday(),
                hours.getThursday(),
                hours.getFriday(),
                hours.getSaturday(),
                hours.getSunday()
        );
    }

    @Override
    public List<WeeklyHoursData> getAll() {
        return repo.findAll().stream()
                .map(((hours) -> new WeeklyHoursData(
                    hours.getId(),
                    hours.getUserIdentifier(),
                    hours.getMonday(),
                    hours.getTuesday(),
                    hours.getWednesday(),
                    hours.getThursday(),
                    hours.getFriday(),
                    hours.getSaturday(),
                    hours.getSunday()
                ))).toList();
    }

    @Override
    public LocalizedOpeningHours getTranslatedData(OpeningHoursTranslatorInterface hoursTranslator) {
        return new LocalizedOpeningHours(
                hoursTranslator.getDay(),
                hoursTranslator.getStart(),
                hoursTranslator.getEnd(),
                hoursTranslator.getMorningHours(),
                hoursTranslator.getAfternoonHours(),
                hoursTranslator.getOpeningHours(),
                getTranslatedDaysOfWeek(hoursTranslator),
                getTranslatedOpeningHours(hoursTranslator),
                getTranslatedTodayHours(hoursTranslator),
                getTranslatedOpenedMessage(hoursTranslator)
        );
    }

    @Override
    public List<LocalizedDayOfWeek> getTranslatedDaysOfWeek(OpeningHoursTranslatorInterface translator) {
        return List.of(
                new LocalizedDayOfWeek(DayOfWeek.MONDAY.getValue(), translator.getMonday()),
                new LocalizedDayOfWeek(DayOfWeek.TUESDAY.getValue(), translator.getTuesday()),
                new LocalizedDayOfWeek(DayOfWeek.WEDNESDAY.getValue(), translator.getWednesday()),
                new LocalizedDayOfWeek(DayOfWeek.THURSDAY.getValue(), translator.getThursday()),
                new LocalizedDayOfWeek(DayOfWeek.FRIDAY.getValue(), translator.getFriday()),
                new LocalizedDayOfWeek(DayOfWeek.SATURDAY.getValue(), translator.getSaturday()),
                new LocalizedDayOfWeek(DayOfWeek.SUNDAY.getValue(), translator.getSunday())
        );
    }

    @Override
    public List<String> getTranslatedOpeningHours(OpeningHoursTranslatorInterface translator) {
        return translator.transformAll(currentGlobalHours.getHours());
    }

    @Override
    public String getTranslatedTodayHours(OpeningHoursTranslatorInterface translator) {
        System.out.println("invoked ************************************************************************************************");
        return translator.transform(currentGlobalHours.getHours(LocalDate.now().getDayOfWeek()));
    }

    @Override
    public String getTranslatedOpenedMessage(OpeningHoursTranslatorInterface translator) {
        return translator.getIsOpenedMessage(isOpened());
    }

    public boolean isOpened() {
        Time now = Time.valueOf(LocalTime.now());
        DailyHours hours = currentGlobalHours.getHours(LocalDate.now().getDayOfWeek());
        return (hours.morningHours() != null && now.after(hours.morningHours().start()) && now.before(hours.morningHours().end())
                || hours.afternoonHours() != null && now.after(hours.afternoonHours().start()) && now.before(hours.afternoonHours().end()));
    }

    @Override
    public void activate(int id) {
        currentGlobalHours = repo.findById(id);
        System.out.println(currentGlobalHours.getId());
    }
}

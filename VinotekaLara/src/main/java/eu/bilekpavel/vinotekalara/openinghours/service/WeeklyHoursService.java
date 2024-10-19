package eu.bilekpavel.vinotekalara.openinghours.service;

import eu.bilekpavel.vinotekalara.openinghours.dto.*;
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
    }

    @Override
    public boolean save(WeeklyHours hours) {
        try {
            System.out.println("WeeklyHours::saving " + hours.getUserIdentifier());
            repo.save(hours);
            System.out.println("Saved id: " + hours.getId());
            System.out.println("---------------------------------------------------");
        } catch (Exception e) {
            return false;
        }
            return true;
    }

    @Override
    public WeeklyHoursData get() {
        if (currentGlobalHours == null) {
            currentGlobalHours = repo.findById(1);
        }
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
        return translator.transform(currentGlobalHours.getHours(LocalDate.now().getDayOfWeek()));
    }

    @Override
    public String getTranslatedOpenedMessage(OpeningHoursTranslatorInterface translator) {
        return translator.getIsOpenedMessage(isOpened());
    }

    @Override
    public WeeklyHours getGlobalHours() {
        if (currentGlobalHours == null) {
            int id = 1; // by default, we chose the first record added in `SpringBootApplication` after startup
            System.out.println("Setting global hours id: " + id);
            currentGlobalHours = repo.findById(id);
            System.out.println("Set: "  + currentGlobalHours.getUserIdentifier());
            System.out.println("---------------------------------------------------");
        }
        return currentGlobalHours;
    }

    @Override
    public HoursWidgetData getWidgetData() {
        return new HoursWidgetData(
            getAll(), get(currentGlobalHours.getId())
        );
    }

    @Override
    public boolean isOpened() {
        LocalTime now = LocalTime.now();
        DailyHours hours = currentGlobalHours.getHours(LocalDate.now().getDayOfWeek());
        return (hours.morningHours() != null
                && now.isAfter(hours.morningHours().start())
                && now.isBefore(hours.morningHours().end())
                || hours.afternoonHours() != null
                && now.isAfter(hours.afternoonHours().start())
                && now.isBefore(hours.afternoonHours().end())
        );
    }

    @Override
    public void activate(int id) {
        currentGlobalHours = repo.findById(id);
        System.out.println(currentGlobalHours.getId());
    }

    @Override
    public void update(int id, DayOfWeek day, DailyHoursRequest data) {
        System.out.println(data.afternoonStart() + " " + data.afternoonEnd());
        DailyHours dailyHours = new DailyHours(
                day,
                data.morningStart() != null && data.morningEnd() != null && !data.morningEnd().isEmpty() && !data.morningStart().isEmpty()
                        ? new TimeInterval(LocalTime.parse(data.morningStart()), LocalTime.parse(data.morningEnd()))
                        : null,
                data.afternoonStart() != null && data.afternoonEnd() != null && !data.afternoonStart().isEmpty() && !data.afternoonEnd().isEmpty()
                        ? new TimeInterval(LocalTime.parse(data.afternoonStart()), LocalTime.parse(data.afternoonEnd()))
                        : null
        );
        WeeklyHours weeklyHours = repo.findById(id);
        weeklyHours.setDailyHours(dailyHours);
        repo.save(weeklyHours);
    }
}

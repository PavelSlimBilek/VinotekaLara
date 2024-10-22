package eu.bilekpavel.vinotekalara.openinghours.service;

import eu.bilekpavel.vinotekalara.openinghours.config.WeeklyHoursConfig;
import eu.bilekpavel.vinotekalara.openinghours.dto.*;
import eu.bilekpavel.vinotekalara.openinghours.model.WeeklyHours;
import eu.bilekpavel.vinotekalara.openinghours.repository.WeeklyHoursRepositoryInterface;
import eu.bilekpavel.vinotekalara.openinghours.translator.OpeningHoursTranslator;
import eu.bilekpavel.vinotekalara.openinghours.translator.OpeningHoursTranslatorDataFactoryInterface;
import eu.bilekpavel.vinotekalara.openinghours.translator.dto.LocalizedDayOfWeek;
import eu.bilekpavel.vinotekalara.openinghours.translator.dto.WeeklyHoursTranslatorData;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class WeeklyHoursService implements WeeklyHoursServiceInterface {

    private final WeeklyHoursRepositoryInterface repo;
    private final WeeklyHoursConfig config;
    private final OpeningHoursTranslatorDataFactoryInterface hoursLocalizationProvider;

    private WeeklyHours currentGlobalHours;

    public WeeklyHoursService(
            @Qualifier("hours_db_repository") WeeklyHoursRepositoryInterface repo,
            WeeklyHoursConfig config,
            OpeningHoursTranslatorDataFactoryInterface hoursLocalizationProvider
    ) {
        this.repo = repo;
        this.config = config;
        this.hoursLocalizationProvider = hoursLocalizationProvider;
    }

    @Override
    public boolean save(WeeklyHours hours) {
        try {
            repo.save(hours);
        } catch (Exception e) {
            return false;
        }
            return true;
    }

    @Override
    public WeeklyHoursData get() {
        if (currentGlobalHours == null) {
            Optional<WeeklyHours> optHour = repo.findFirstBy();
            currentGlobalHours = optHour.orElseThrow(RuntimeException::new);
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
        Optional<WeeklyHours> optHour = repo.findById(id);
        WeeklyHours hours = optHour.orElseThrow(RuntimeException::new);

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
    public List<WeeklyHoursData> getAll(boolean allowRemoved) {
        return repo.findAll().stream()
                .filter((hours) -> allowRemoved || !hours.isRemoved())
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
    public LocalizedOpeningHours getTranslatedData(OpeningHoursTranslator hoursTranslator) {
        return new LocalizedOpeningHours(
                hoursTranslator.day(),
                hoursTranslator.start(),
                hoursTranslator.end(),
                hoursTranslator.morningHours(),
                hoursTranslator.afternoonHours(),
                hoursTranslator.openingHours(),
                getTranslatedDaysOfWeek(hoursTranslator),
                getTranslatedOpeningHours(hoursTranslator),
                getTranslatedTodayHours(hoursTranslator),
                getTranslatedOpenedMessage(hoursTranslator)
        );
    }

    @Override
    public List<LocalizedDayOfWeek> getTranslatedDaysOfWeek(OpeningHoursTranslator translator) {
        return List.of(
                new LocalizedDayOfWeek(DayOfWeek.MONDAY.getValue(), translator.monday()),
                new LocalizedDayOfWeek(DayOfWeek.TUESDAY.getValue(), translator.tuesday()),
                new LocalizedDayOfWeek(DayOfWeek.WEDNESDAY.getValue(), translator.wednesday()),
                new LocalizedDayOfWeek(DayOfWeek.THURSDAY.getValue(), translator.thursday()),
                new LocalizedDayOfWeek(DayOfWeek.FRIDAY.getValue(), translator.friday()),
                new LocalizedDayOfWeek(DayOfWeek.SATURDAY.getValue(), translator.saturday()),
                new LocalizedDayOfWeek(DayOfWeek.SUNDAY.getValue(), translator.sunday())
        );
    }

    @Override
    public List<String> getTranslatedOpeningHours(OpeningHoursTranslator translator) {
        return translator.transformAll(currentGlobalHours.getHours());
    }

    @Override
    public String getTranslatedTodayHours(OpeningHoursTranslator translator) {
        return translator.transform(currentGlobalHours.getHours(LocalDate.now().getDayOfWeek()));
    }

    @Override
    public String getTranslatedOpenedMessage(OpeningHoursTranslator translator) {
        return translator.isOpenedMessage(isOpened());
    }

    @Override
    public WeeklyHours getGlobalHours() {
        if (currentGlobalHours == null) {
            Optional<WeeklyHours> optHours = repo.findFirstBy();
            currentGlobalHours = optHours.orElseThrow(RuntimeException::new);
        }
        return currentGlobalHours;
    }

    @Override
    public HoursWidgetData getWidgetData() {
        return new HoursWidgetData(
            getAll(false), get(currentGlobalHours.getId())
        );
    }

    @Override
    public WeeklyHoursTranslatorData getTranslatorData(OpeningHoursTranslator locale) {
        return hoursLocalizationProvider.create(locale);
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
        Optional<WeeklyHours> optHour = repo.findById(id);
        currentGlobalHours = optHour.orElse(currentGlobalHours);
    }

    @Override
    public void update(int id, DayOfWeek day, DailyHoursRequest data) {
        DailyHours dailyHours = new DailyHours(
                day,
                data.morningStart() != null && data.morningEnd() != null && !data.morningEnd().isEmpty() && !data.morningStart().isEmpty()
                        ? new TimeInterval(LocalTime.parse(data.morningStart()), LocalTime.parse(data.morningEnd()))
                        : null,
                data.afternoonStart() != null && data.afternoonEnd() != null && !data.afternoonStart().isEmpty() && !data.afternoonEnd().isEmpty()
                        ? new TimeInterval(LocalTime.parse(data.afternoonStart()), LocalTime.parse(data.afternoonEnd()))
                        : null
        );

        Optional<WeeklyHours> optHours = repo.findById(id);
        if (optHours.isEmpty()) {
            return;
        }

        optHours.get().setDailyHours(dailyHours);
        repo.save(optHours.get());
    }

    @Override
    public boolean areAfternoonHoursAllowed() {
        return config.areAfternoonHoursAllowed();
    }

    @Override
    public void allowAfternoonHours(boolean isAllowed) {
        config.allowAfternoonHours(isAllowed);
    }

    @Override
    public void delete(int id) {
        if (id == currentGlobalHours.getId()) {
            throw new RuntimeException("Cannot remove global hours");
        }

        Optional<WeeklyHours> optHours = repo.findById(id);
        if(optHours.isEmpty()) {
            return;
        }

        optHours.get().setRemoved(true);
        repo.save(optHours.get());
    }

    @Override
    public void create(String name) {
        WeeklyHours hours = new WeeklyHours(name);
        repo.save(hours);
    }

    @Override
    public void setIdentifier(int id, String name) {
        Optional<WeeklyHours> optHours = repo.findById(id);
        if (optHours.isEmpty()) {
            return;
        }

        WeeklyHours hours = optHours.get();
        hours.setUserIdentifier(name);
        repo.save(hours);
    }
}

package eu.bilekpavel.vinotekalara.openinghours.service;

import eu.bilekpavel.vinotekalara.openinghours.dto.DailyHoursRequest;
import eu.bilekpavel.vinotekalara.openinghours.dto.HoursWidgetData;
import eu.bilekpavel.vinotekalara.openinghours.dto.LocalizedOpeningHours;
import eu.bilekpavel.vinotekalara.openinghours.dto.WeeklyHoursData;
import eu.bilekpavel.vinotekalara.openinghours.model.WeeklyHours;
import eu.bilekpavel.vinotekalara.openinghours.translator.OpeningHoursTranslator;
import eu.bilekpavel.vinotekalara.openinghours.translator.dto.LocalizedDayOfWeek;
import eu.bilekpavel.vinotekalara.openinghours.translator.dto.WeeklyHoursTranslatorData;

import java.time.DayOfWeek;
import java.util.List;

public interface WeeklyHoursServiceInterface {
    boolean save(WeeklyHours hours);
    WeeklyHoursData get();
    WeeklyHoursData get(int id);
    List<WeeklyHoursData> getAll(boolean allowRemoved);
    LocalizedOpeningHours getTranslatedData(OpeningHoursTranslator hoursTranslator);
    List<LocalizedDayOfWeek> getTranslatedDaysOfWeek(OpeningHoursTranslator translator);
    List<String> getTranslatedOpeningHours(OpeningHoursTranslator translator);
    String getTranslatedTodayHours(OpeningHoursTranslator translator);
    String getTranslatedOpenedMessage(OpeningHoursTranslator translator);
    WeeklyHours getGlobalHours();
    boolean isOpened();
    void activate(int id);
    void update(int id, DayOfWeek day, DailyHoursRequest data);
    boolean areAfternoonHoursAllowed();

    void allowAfternoonHours(boolean isAllow);
    void delete(int id);

    void create(String name);
    void setIdentifier(int id, String name);

    HoursWidgetData getWidgetData();
    WeeklyHoursTranslatorData getTranslatorData(OpeningHoursTranslator locale);
}

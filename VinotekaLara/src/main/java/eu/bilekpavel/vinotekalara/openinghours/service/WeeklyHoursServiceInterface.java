package eu.bilekpavel.vinotekalara.openinghours.service;

import eu.bilekpavel.vinotekalara.openinghours.dto.DailyHoursRequest;
import eu.bilekpavel.vinotekalara.openinghours.dto.HoursWidgetData;
import eu.bilekpavel.vinotekalara.openinghours.dto.LocalizedOpeningHours;
import eu.bilekpavel.vinotekalara.openinghours.dto.WeeklyHoursData;
import eu.bilekpavel.vinotekalara.openinghours.model.WeeklyHours;
import eu.bilekpavel.vinotekalara.openinghours.translator.OpeningHoursTranslatorInterface;
import eu.bilekpavel.vinotekalara.openinghours.translator.dto.LocalizedDayOfWeek;

import java.time.DayOfWeek;
import java.util.List;

public interface WeeklyHoursServiceInterface {
    boolean save(WeeklyHours hours);
    WeeklyHoursData get();
    WeeklyHoursData get(int id);
    List<WeeklyHoursData> getAll();
    LocalizedOpeningHours getTranslatedData(OpeningHoursTranslatorInterface hoursTranslator);
    List<LocalizedDayOfWeek> getTranslatedDaysOfWeek(OpeningHoursTranslatorInterface translator);
    List<String> getTranslatedOpeningHours(OpeningHoursTranslatorInterface translator);
    String getTranslatedTodayHours(OpeningHoursTranslatorInterface translator);
    String getTranslatedOpenedMessage(OpeningHoursTranslatorInterface translator);
    WeeklyHours getGlobalHours();
    HoursWidgetData getWidgetData();
    boolean isOpened();
    void activate(int id);
    void update(int id, DayOfWeek day, DailyHoursRequest data);
}

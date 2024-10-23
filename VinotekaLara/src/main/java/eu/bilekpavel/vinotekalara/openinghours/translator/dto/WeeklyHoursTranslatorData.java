package eu.bilekpavel.vinotekalara.openinghours.translator.dto;

import java.time.DayOfWeek;
import java.util.List;

public record WeeklyHoursTranslatorData(
        String openingHours,
        String selectHours,
        String activeHours,
        String setHours,
        String day,
        String monday,
        String tuesday,
        String wednesday,
        String thursday,
        String friday,
        String saturday,
        String sunday,
        String start,
        String end,
        String morningHours,
        String afternoonHours
) {
    public List<LocalizedDayOfWeek> daysOfWeek() {
        return List.of(
                new LocalizedDayOfWeek(DayOfWeek.MONDAY.getValue(), monday),
                new LocalizedDayOfWeek(DayOfWeek.TUESDAY.getValue(), tuesday),
                new LocalizedDayOfWeek(DayOfWeek.WEDNESDAY.getValue(), wednesday),
                new LocalizedDayOfWeek(DayOfWeek.THURSDAY.getValue(), thursday),
                new LocalizedDayOfWeek(DayOfWeek.FRIDAY.getValue(), friday),
                new LocalizedDayOfWeek(DayOfWeek.SATURDAY.getValue(), saturday),
                new LocalizedDayOfWeek(DayOfWeek.SUNDAY.getValue(), sunday)
        );
    }
}

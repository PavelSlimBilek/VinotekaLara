package eu.bilekpavel.vinotekalara.openinghours.translator.dto;

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
}

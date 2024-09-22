package eu.bilekpavel.vinotekalara.openinghours.dto;

public record WeeklyHoursData(
        int id,
        String userIdentifier,
        DailyHours monday,
        DailyHours tuesday,
        DailyHours wednesday,
        DailyHours thursday,
        DailyHours friday,
        DailyHours saturday,
        DailyHours sunday
) {
}

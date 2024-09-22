package eu.bilekpavel.vinotekalara.openinghours.dto;

public record DailyHoursRequest(
        String dayValue, // as from DaysOfWeek.class
        String morningStart,
        String morningEnd,
        String afternoonStart,
        String afternoonEnd
) {
}
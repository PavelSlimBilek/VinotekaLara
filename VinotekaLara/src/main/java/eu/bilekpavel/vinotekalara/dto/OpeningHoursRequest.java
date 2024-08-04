package eu.bilekpavel.vinotekalara.dto;

public record OpeningHoursRequest(
        String day,
        String morningStart,
        String morningEnd,
        String afternoonStart,
        String afternoonEnd
) {
}
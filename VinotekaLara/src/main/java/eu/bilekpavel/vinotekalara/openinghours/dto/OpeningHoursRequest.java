package eu.bilekpavel.vinotekalara.openinghours.dto;

public record OpeningHoursRequest(
        String day,
        String morningStart,
        String morningEnd,
        String afternoonStart,
        String afternoonEnd
) {
}
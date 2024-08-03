package eu.bilekpavel.vinotekalara.dto;

public record OpeningHoursRequest(
        String day,
        String start,
        String end
) {
}
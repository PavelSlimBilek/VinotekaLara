package eu.bilekpavel.vinotekalara.openinghours.translator.dto;

public record LocalizedDayOfWeek(
        int dayValue, // as from DaysOfWeek.class
        String translation
) {
}
package eu.bilekpavel.vinotekalara.openinghours.translator.dto;

public record TranslatedDayOfWeek(
        int dayValue, // as from DaysOfWeek.class
        String translation
) {
}
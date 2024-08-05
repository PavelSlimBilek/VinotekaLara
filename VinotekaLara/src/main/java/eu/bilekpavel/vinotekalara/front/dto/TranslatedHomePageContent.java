package eu.bilekpavel.vinotekalara.front.dto;

public record TranslatedHomePageContent(
        String lang,
        String title,
        String welcomeMessage,
        String description
) {
}
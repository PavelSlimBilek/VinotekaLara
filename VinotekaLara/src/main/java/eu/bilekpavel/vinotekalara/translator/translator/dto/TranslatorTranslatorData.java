package eu.bilekpavel.vinotekalara.translator.translator.dto;

public record TranslatorTranslatorData(
        String language,
        String languages,
        String supportedLanguages,
        String allowedLanguages,
        String selectDefaultLanguage,
        String toggleLanguages,
        String updateLocalizations
) {
}

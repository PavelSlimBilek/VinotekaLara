package eu.bilekpavel.vinotekalara.translator.dto;

import eu.bilekpavel.vinotekalara.translator.language.Language;

import java.util.List;

public record LanguageWidgetData(
        List<Language> supportedLanguages,
        Language defaultLanguage
) {
}

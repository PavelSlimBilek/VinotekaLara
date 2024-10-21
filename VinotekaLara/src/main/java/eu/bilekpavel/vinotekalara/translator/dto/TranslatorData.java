package eu.bilekpavel.vinotekalara.translator.dto;

import eu.bilekpavel.vinotekalara.translator.api.Translator;
import eu.bilekpavel.vinotekalara.translator.language.Language;

import java.util.List;

public record TranslatorData(
        String langCode,
        Language activeLanguage,
        List<Translator> locales,
        List<Language> allowedLanguages
) {
}
package eu.bilekpavel.vinotekalara.translator.dto;

import eu.bilekpavel.vinotekalara.translator.language.Language;

public record LocalizedString(
        Language language,
        String content
) {
}
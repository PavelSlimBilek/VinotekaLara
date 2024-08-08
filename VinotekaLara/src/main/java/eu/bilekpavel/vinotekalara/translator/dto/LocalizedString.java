package eu.bilekpavel.vinotekalara.translator.dto;

import eu.bilekpavel.vinotekalara.translator.language.Language;

public record LocalizedString(
        Language language,
        String content
) {
    public LocalizedString {
        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("Content must not be blank or null");
        }
    }
}
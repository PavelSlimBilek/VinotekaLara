package eu.bilekpavel.vinotekalara.news.dto;

import eu.bilekpavel.vinotekalara.translator.dto.LocalizedString;
import eu.bilekpavel.vinotekalara.translator.language.Language;

import java.util.Map;

public record NewsFullData(
        int id,
        Map<Language, LocalizedString> title,
        Map<Language, LocalizedString> content
) {
}

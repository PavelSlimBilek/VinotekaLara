package eu.bilekpavel.vinotekalara.news.translator.dto;

import eu.bilekpavel.vinotekalara.translator.dto.LocalizedString;

public record LocalizedNews(
        int id,
        boolean isActive,
        LocalizedString title,
        LocalizedString content
) {
}

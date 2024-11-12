package eu.bilekpavel.vinotekalara.news.dto;

import eu.bilekpavel.vinotekalara.translator.dto.LocalizedStringRequest;

public record NewsRequest(
        LocalizedStringRequest title,
        LocalizedStringRequest content
) {
}

package eu.bilekpavel.vinotekalara.alertbar.dto;

import eu.bilekpavel.vinotekalara.translator.dto.LocalizedString;

public record AlertRequest(
        LocalizedString content,
        String backgroundColor
) {
}
package eu.bilekpavel.vinotekalara.alertbar.dto;

import eu.bilekpavel.vinotekalara.translator.dto.LocalizedString;

public record LocalizedAlert(
        LocalizedString content,
        String backgroundColor
) {
}

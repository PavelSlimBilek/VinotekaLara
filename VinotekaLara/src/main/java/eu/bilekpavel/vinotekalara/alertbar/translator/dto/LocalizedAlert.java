package eu.bilekpavel.vinotekalara.alertbar.translator.dto;

import eu.bilekpavel.vinotekalara.translator.dto.LocalizedString;

public record LocalizedAlert(
        int id,
        boolean isActive,
        LocalizedString content,
        String backgroundColor,
        String fontColor
) {
}

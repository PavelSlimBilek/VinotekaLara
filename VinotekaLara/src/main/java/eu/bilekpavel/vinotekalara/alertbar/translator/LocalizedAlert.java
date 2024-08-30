package eu.bilekpavel.vinotekalara.alertbar.translator;

import eu.bilekpavel.vinotekalara.translator.dto.LocalizedString;

public record LocalizedAlert(
        LocalizedString content,
        String backgroundColor
) {
}

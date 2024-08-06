package eu.bilekpavel.vinotekalara.alertbar.translator.dto;

import eu.bilekpavel.vinotekalara.translator.dto.Language;
import eu.bilekpavel.vinotekalara.translator.dto.LocalizedString;

public record TranslatedAlert(
        Language language,
        LocalizedString content,
        String backgroundColor
) {
}
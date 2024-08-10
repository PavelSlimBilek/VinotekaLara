package eu.bilekpavel.vinotekalara.alertbar.translator;

import eu.bilekpavel.vinotekalara.translator.domain.LocalizedString;
import eu.bilekpavel.vinotekalara.translator.language.Language;

public record TranslatedAlert(
        Language language,
        LocalizedString content,
        String backgroundColor
) {
}
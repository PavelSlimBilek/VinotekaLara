package eu.bilekpavel.vinotekalara.alertbar.dto;

import eu.bilekpavel.vinotekalara.translator.dto.LocalizedString;
import eu.bilekpavel.vinotekalara.translator.language.Language;

import java.util.Map;

public record AlertFullData(
    int id,
    Map<Language, String> localizedStrings,
    String backgroundColor
) {
    public LocalizedString getLocalized(Language language) {
        return new LocalizedString(language, localizedStrings.get(language));
    }
}

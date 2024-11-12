package eu.bilekpavel.vinotekalara.alertbar.dto;

import eu.bilekpavel.vinotekalara.app.module.color.dto.Color;
import eu.bilekpavel.vinotekalara.translator.dto.LocalizedString;
import eu.bilekpavel.vinotekalara.translator.language.Language;

import java.util.Map;

public record AlertFullData(
    int id,
    Map<Language, String> content,
    Color backgroundColor,
    Color fontColor
) {
    public LocalizedString getLocalized(Language language) {
        return new LocalizedString(language, content.get(language));
    }
}

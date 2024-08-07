package eu.bilekpavel.vinotekalara.alertbar.model;

import eu.bilekpavel.vinotekalara.translator.dto.LocalizedString;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Alert {

    private final Map<Language, LocalizedString> localizations;
    private final String backgroundColor;

    public Alert(String czech, String english, String german, String backgroundColor) {
        localizations = new HashMap<>();
        localizations.put(Language.CZECH, new LocalizedString(Language.CZECH, czech));
        localizations.put(Language.ENGLISH, new LocalizedString(Language.ENGLISH, english));
        localizations.put(Language.GERMAN, new LocalizedString(Language.GERMAN, german));
        this.backgroundColor = backgroundColor;
    }

    public LocalizedString getLocalizedContent(Language language) {
        return localizations.get(language);
    }
}
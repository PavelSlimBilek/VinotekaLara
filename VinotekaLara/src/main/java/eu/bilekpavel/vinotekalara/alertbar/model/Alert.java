package eu.bilekpavel.vinotekalara.alertbar.model;

import eu.bilekpavel.vinotekalara.alertbar.dto.AlertRequest;
import eu.bilekpavel.vinotekalara.translator.dto.LocalizedString;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Alert {

    private final static String defaultColor = "444";

    private final LocalizedString defaultLocalization;
    private final Map<Language, LocalizedString> localizations;
    private final String backgroundColor;

    public Alert(AlertRequest request) {
        this(request.content());
    }

    private Alert(LocalizedString localization) {
        defaultLocalization = localization;
        localizations = new HashMap<>();
        backgroundColor = defaultColor;
    }

    public LocalizedString getLocalizedContent(Language language) {
        LocalizedString localization = localizations.get(language);
        return localization != null ? localization : defaultLocalization;
    }
}
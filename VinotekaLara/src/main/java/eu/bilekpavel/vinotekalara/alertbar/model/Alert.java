package eu.bilekpavel.vinotekalara.alertbar.model;

import eu.bilekpavel.vinotekalara.alertbar.dto.AlertRequest;
import eu.bilekpavel.vinotekalara.translator.domain.LocalizedString;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Alert {

    private final LocalizedString defaultLocalization;
    private final Map<Language, LocalizedString> localizations;
    private String backgroundColor;

    public Alert(AlertRequest request) {
        defaultLocalization = request.defaultContent();

        localizations = new HashMap<>();
        request.additionalTranslations().forEach(localization -> {
            localizations.put(localization.getLanguage(), localization);
        });

        this.backgroundColor = request.backgroundColor();
    }

    public LocalizedString getLocalizedContent(Language language) {
        LocalizedString localization = localizations.get(language);
        return localization != null ? localization : defaultLocalization;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public void setLocalizedContent(Language lang, String content) {
        if (defaultLocalization.getLanguage() == lang) {
            defaultLocalization.setContent(content);
            return;
        }

        localizations.forEach((k, v) -> {
            if (k == lang) {
                v.setContent(content);
            }
            return;
        });


    }
}
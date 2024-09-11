package eu.bilekpavel.vinotekalara.alertbar.domain;

import eu.bilekpavel.vinotekalara.translator.dto.LocalizedString;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class Alert {

    public static int ID = 1;

    @Getter
    private final int id;

    private final Map<Language, String> localizations;

    @Setter
    @Getter
    private String backgroundColor;

    public Alert() {
        localizations = new HashMap<>();
        id = generateId();
    }

    public String getLocalized(Language language) {
        return localizations.get(language);
    }

    public void updateLocalization(LocalizedString content) {
        this.localizations.put(content.language(), content.content());
    }

    private int generateId() {
        return ID++;
    }
}

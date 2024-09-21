package eu.bilekpavel.vinotekalara.alertbar.domain;

import eu.bilekpavel.vinotekalara.translator.dto.LocalizedString;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Entity
public class Alert {

    public static int ID = 1;

    @Id
    @Getter
    private final int id;

    @ElementCollection
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

package eu.bilekpavel.vinotekalara.alertbar.domain;

import eu.bilekpavel.vinotekalara.translator.dto.LocalizedString;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Entity
public class Alert {

    @Id
    @GeneratedValue
    private int id;

    private boolean isActive;
    @Setter
    private boolean isRemoved;

    @ElementCollection
    private final Map<Language, String> localizations;

    @Setter
    private String backgroundColor;

    public Alert() {
        localizations = new HashMap<>();
        isActive = false;
    }

    public String getLocalized(Language language) {
        return localizations.get(language);
    }

    public void updateLocalization(LocalizedString content) {
        this.localizations.put(content.language(), content.content());
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
}

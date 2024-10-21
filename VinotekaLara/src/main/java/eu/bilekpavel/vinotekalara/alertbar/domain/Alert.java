package eu.bilekpavel.vinotekalara.alertbar.domain;

import eu.bilekpavel.vinotekalara.app.dto.Color;
import eu.bilekpavel.vinotekalara.translator.dto.LocalizedString;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import jakarta.persistence.*;
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

    @Embedded
    @Setter
    @AttributeOverrides({
            @AttributeOverride(name = "red", column = @Column(name = "background_red")),
            @AttributeOverride(name = "green", column = @Column(name = "background_green")),
            @AttributeOverride(name = "blue", column = @Column(name = "background_blue"))
    })
    private Color backgroundColor;

    @Embedded
    @Setter
    @AttributeOverrides({
            @AttributeOverride(name = "red", column = @Column(name = "font_red")),
            @AttributeOverride(name = "green", column = @Column(name = "font_green")),
            @AttributeOverride(name = "blue", column = @Column(name = "font_blue"))
    })
    private Color fontColor;

    public Alert() {
        localizations = new HashMap<>();
        isActive = false;
        backgroundColor = new Color(255, 255, 255);
        fontColor = new Color(0, 0, 0);
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

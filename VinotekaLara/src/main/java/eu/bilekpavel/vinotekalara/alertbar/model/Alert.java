package eu.bilekpavel.vinotekalara.alertbar.model;

import eu.bilekpavel.vinotekalara.app.api.internal.SoftRemovable;
import eu.bilekpavel.vinotekalara.app.api.internal.Switchable;
import eu.bilekpavel.vinotekalara.app.module.color.dto.Color;
import eu.bilekpavel.vinotekalara.translator.dto.LocalizedString;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Entity
public final class Alert implements SoftRemovable, Switchable {

    @Id
    @GeneratedValue
    private int id;

    @Setter
    private String userIdentifier;

    private boolean isActive;

    @Setter
    private boolean removed;

    @ElementCollection
    private final Map<Language, String> content;

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
        content = new HashMap<>();
        isActive = false;
        backgroundColor = new Color(255, 255, 255);
        fontColor = new Color(0, 0, 0);
    }

    public String getContent(Language language) {
        return content.get(language);
    }

    public void updateContent(LocalizedString content) {
        this.content.put(content.language(), content.content());
    }


    @Override
    public void remove() {
        removed = true;
    }

    @Override
    public void restore() {
        removed = false;
    }

    @Override
    public boolean isRemoved() {
        return removed;
    }

    @Override
    public void setActiveState() {
        isActive = true;
    }

    @Override
    public void setInactiveState() {
        isActive = false;
    }

    @Override
    public boolean isInActiveState() {
        return isActive;
    }
}

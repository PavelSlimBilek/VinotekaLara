package eu.bilekpavel.vinotekalara.news.model;

import eu.bilekpavel.vinotekalara.app.api.internal.SoftRemovable;
import eu.bilekpavel.vinotekalara.app.api.internal.Switchable;
import eu.bilekpavel.vinotekalara.translator.dto.LocalizedString;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;

import java.util.HashMap;
import java.util.Map;

@Entity
@Getter
@NoArgsConstructor
public final class News implements SoftRemovable, Switchable {

    @Id
    @GeneratedValue
    private int id;

    private boolean isActive;
    private boolean isRemoved;

    // TODO solve the EAGER fetching HERE!!!
    @ElementCollection(fetch = FetchType.EAGER)
    private Map<Language, String> title;

    @ElementCollection(fetch = FetchType.EAGER)
    private Map<Language, String> content;

    public News(LocalizedString title, LocalizedString content) {
        isActive = true;
        isRemoved = false;

        this.content = new HashMap<>();
        this.content.put(content.language(), content.content());

        this.title = new HashMap<>();
        this.title.put(title.language(), title.content());
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

    @Override
    public void remove() {
        isRemoved = true;
    }

    @Override
    public void restore() {
        isRemoved = false;
    }

    @Override
    public boolean isRemoved() {
        return isRemoved;
    }

    public void updateContent(LocalizedString content) {
        this.content.put(content.language(), content.content());
    }

    public void updateTitle(LocalizedString title) {
        this.title.put(title.language(), title.content());
    }

    public String getContent(Language language) {
        return content.get(language);
    }

    public String getTitle(Language language) {
        return title.get(language);
    }
}

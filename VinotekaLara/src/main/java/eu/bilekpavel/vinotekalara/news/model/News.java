package eu.bilekpavel.vinotekalara.news.model;

import eu.bilekpavel.vinotekalara.app.api.internal.SoftRemovable;
import eu.bilekpavel.vinotekalara.app.api.internal.Switchable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
public final class News implements SoftRemovable, Switchable {

    @Id
    @GeneratedValue
    private int id;

    @Setter
    private String content;

    private boolean isActive;
    private boolean isRemoved;

    public News(String content) {
        isActive = true;
        this.content = content.trim();
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
}

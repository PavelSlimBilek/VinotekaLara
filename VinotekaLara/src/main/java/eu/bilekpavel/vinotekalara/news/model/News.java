package eu.bilekpavel.vinotekalara.news.model;

import eu.bilekpavel.vinotekalara.app.api.internal.Switchable;
import eu.bilekpavel.vinotekalara.news.dto.NewsRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
public final class News implements Switchable {

    @Id
    @GeneratedValue
    private int id;

    @Setter
    private String content;

    private boolean isActive = true;

    public News(NewsRequest request) {
        content = request.content();
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

package eu.bilekpavel.vinotekalara.app.module.color.model;

import eu.bilekpavel.vinotekalara.app.module.color.dto.Color;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public final class Palette {

    @Id
    @GeneratedValue
    private int id;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<Color> colors;

    public Palette(List<Color> colors) {
        this.colors = colors;
    }
}

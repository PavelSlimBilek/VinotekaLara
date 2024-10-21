package eu.bilekpavel.vinotekalara.app.dto;

import jakarta.persistence.Embeddable;

@Embeddable
public record Color(
        int red,
        int green,
        int blue
) {
    public String toRgbString() {
        return String.format("rgb(%d, %d, %d)", red, green, blue);
    }
}
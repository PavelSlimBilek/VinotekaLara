package eu.bilekpavel.vinotekalara.openinghours.dto;

import jakarta.persistence.Embeddable;

import java.sql.Time;

@Embeddable
public record TimeInterval(
        Time start,
        Time end
) {
}
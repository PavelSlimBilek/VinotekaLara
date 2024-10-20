package eu.bilekpavel.vinotekalara.openinghours.dto;

import jakarta.persistence.Embeddable;

import java.time.LocalTime;

@Embeddable
public record TimeInterval(
        LocalTime start,
        LocalTime end
) {
}
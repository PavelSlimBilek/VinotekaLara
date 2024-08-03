package eu.bilekpavel.vinotekalara.dto;

import java.time.DayOfWeek;

public record OpeningHours(
        DayOfWeek day,
        TimeInterval interval
) {
}
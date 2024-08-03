package eu.bilekpavel.vinotekalara.dto;

import java.sql.Time;

public record TimeInterval(
        Time start,
        Time end
) {
}
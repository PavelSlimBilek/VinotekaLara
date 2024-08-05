package eu.bilekpavel.vinotekalara.openinghours.dto;

import java.sql.Time;

public record TimeInterval(
        Time start,
        Time end
) {
}
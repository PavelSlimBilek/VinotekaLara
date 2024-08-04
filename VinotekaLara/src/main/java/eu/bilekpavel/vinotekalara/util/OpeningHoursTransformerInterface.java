package eu.bilekpavel.vinotekalara.util;

import eu.bilekpavel.vinotekalara.dto.OpeningHours;

import java.util.List;

public interface OpeningHoursTransformerInterface {
    String transform(OpeningHours hours);
    List<String> transformAll(List<OpeningHours> hours);
}

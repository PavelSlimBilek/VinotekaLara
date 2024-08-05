package eu.bilekpavel.vinotekalara.translator.model;

import eu.bilekpavel.vinotekalara.translator.dto.Flag;
import eu.bilekpavel.vinotekalara.translator.dto.Language;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Localization {
    private Language language;
    private Flag flag;
    private String code;
}
package eu.bilekpavel.vinotekalara.translator.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LocalizedString {

    private Language language;
    private String content;
}
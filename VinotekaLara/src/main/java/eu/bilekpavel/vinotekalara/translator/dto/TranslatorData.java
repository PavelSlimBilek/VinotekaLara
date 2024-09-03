package eu.bilekpavel.vinotekalara.translator.dto;

import eu.bilekpavel.vinotekalara.translator.Translator;

import java.util.List;

public record TranslatorData(
        String langCode,
        List<Translator> flags
) {
}
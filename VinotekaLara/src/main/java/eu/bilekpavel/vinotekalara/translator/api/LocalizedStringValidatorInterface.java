package eu.bilekpavel.vinotekalara.translator.api;

import eu.bilekpavel.vinotekalara.translator.error.TranslatorException;

public interface LocalizedStringValidatorInterface {
    void validate(String langCode, String payload) throws TranslatorException;
}

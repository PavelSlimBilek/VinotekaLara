package eu.bilekpavel.vinotekalara.translator.api;

import eu.bilekpavel.vinotekalara.translator.error.LocalizedStringException;

public interface LocalizedStringValidatorInterface {
    void validate(String langCode, String payload) throws LocalizedStringException;
}

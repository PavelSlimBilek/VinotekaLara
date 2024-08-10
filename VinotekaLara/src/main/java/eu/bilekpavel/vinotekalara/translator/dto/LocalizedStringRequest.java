package eu.bilekpavel.vinotekalara.translator.dto;

import eu.bilekpavel.vinotekalara.translator.error.LocalizedStringValidationError;
import eu.bilekpavel.vinotekalara.translator.language.Language;

public record LocalizedStringRequest(
        String payload,
        Language language
) {
    public LocalizedStringRequest {
        if (payload == null || payload.trim().isEmpty()) {
            throw new LocalizedStringValidationError("Payload is null or empty");
        }

        if (language == null) {
            throw new LocalizedStringValidationError("Language is null");
        }
    }
}

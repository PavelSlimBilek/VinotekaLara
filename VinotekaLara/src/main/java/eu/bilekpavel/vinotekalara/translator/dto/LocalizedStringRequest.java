package eu.bilekpavel.vinotekalara.translator.dto;

import eu.bilekpavel.vinotekalara.translator.error.LocalizedStringException;
import jakarta.annotation.Nullable;

public record LocalizedStringRequest(
        @Nullable
        String payload,
        String langCode
) {
    public LocalizedStringRequest {
        if (langCode == null) {
            throw new LocalizedStringException("Language is null");
        }
    }
}

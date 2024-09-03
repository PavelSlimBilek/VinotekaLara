package eu.bilekpavel.vinotekalara.translator.dto;

public record LocalizedStringRequest(
        String payload,
        String langCode
) {
}

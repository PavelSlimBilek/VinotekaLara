package eu.bilekpavel.vinotekalara.alertbar.dto;

import eu.bilekpavel.vinotekalara.translator.dto.LocalizedStringRequest;

import java.util.List;

public record AlertRequest(
        List<LocalizedStringRequest> translations,
        String backgroundColor
) {
}
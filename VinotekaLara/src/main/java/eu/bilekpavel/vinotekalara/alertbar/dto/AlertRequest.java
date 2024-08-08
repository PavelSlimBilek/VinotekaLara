package eu.bilekpavel.vinotekalara.alertbar.dto;

import eu.bilekpavel.vinotekalara.translator.dto.LocalizedString;

import java.util.List;

public record AlertRequest(
        LocalizedString defaultContent,
        List<LocalizedString> localizedContent,
        String backgroundColor
) {
}
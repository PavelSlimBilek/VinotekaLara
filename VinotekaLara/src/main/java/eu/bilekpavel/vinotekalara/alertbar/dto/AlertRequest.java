package eu.bilekpavel.vinotekalara.alertbar.dto;

import eu.bilekpavel.vinotekalara.alertbar.error.AlertValidationError;
import eu.bilekpavel.vinotekalara.translator.domain.LocalizedString;
import eu.bilekpavel.vinotekalara.translator.error.LocalizedStringValidationError;

import java.util.List;

public record AlertRequest(
        LocalizedString defaultContent,
        List<LocalizedString> additionalTranslations,
        String backgroundColor
) {
    private static final String DEFAULT_COLOR = "#442200";

    public AlertRequest(
            LocalizedString defaultContent,
            List<LocalizedString> additionalTranslations,
            String backgroundColor
    ) {
        try {
            this.defaultContent = defaultContent;
            this.additionalTranslations = additionalTranslations;
        } catch (LocalizedStringValidationError ve) {
            throw new AlertValidationError(ve.getMessage() + "\n\nLocalizedStringValidationError ***** !!");
        }

        if (backgroundColor != null
                && !backgroundColor.isBlank()
                && backgroundColor.length() != 7
                && backgroundColor.matches("^#[0-9a-fA-F]{6}$")
        ) {
            this.backgroundColor = DEFAULT_COLOR;
            throw new AlertValidationError("Background color must not be empty!!");
        }

        this.backgroundColor = backgroundColor.toLowerCase();
    }
}
package eu.bilekpavel.vinotekalara.translator.translator.internal;

import eu.bilekpavel.vinotekalara.translator.translator.TranslatorTranslator;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AbstractTranslatorTranslator implements TranslatorTranslator {
    private final String LANGUAGE;
    private final String LANGUAGES;
    private final String SUPPORTED_LANGUAGES;
    private final String ALLOWED_LANGUAGES;
    private final String SELECT_DEFAULT_LANGUAGE;
    private final String TOGGLE_LANGUAGE;
    private final String UPDATE_LOCALIZATIONS;

    @Override
    public String language() {
        return LANGUAGE;
    }

    @Override
    public String languages() {
        return LANGUAGES;
    }

    @Override
    public String supportedLanguages() {
        return SUPPORTED_LANGUAGES;
    }

    @Override
    public String allowedLanguages() {
        return ALLOWED_LANGUAGES;
    }

    @Override
    public String selectDefaultLanguage() {
        return SELECT_DEFAULT_LANGUAGE;
    }

    @Override
    public String toggleLanguages() {
        return TOGGLE_LANGUAGE;
    }

    @Override
    public String updateLocalizations() {
        return UPDATE_LOCALIZATIONS;
    }
}

package eu.bilekpavel.vinotekalara.translator.translator.internal.languages;

import eu.bilekpavel.vinotekalara.translator.translator.internal.AbstractTranslatorTranslator;
import org.springframework.stereotype.Component;

@Component
public final class SampleTranslatorTranslator extends AbstractTranslatorTranslator {

    public SampleTranslatorTranslator() {
        super(
                "LANGUAGE",
                "LANGUAGES",
                "SUPPORTED_LANGUAGES",
                "ALLOWED_LANGUAGES",
                "SELECT_DEFAULT_LANGUAGE",
                "TOGGLE_LANGUAGE"
        );
    }
}

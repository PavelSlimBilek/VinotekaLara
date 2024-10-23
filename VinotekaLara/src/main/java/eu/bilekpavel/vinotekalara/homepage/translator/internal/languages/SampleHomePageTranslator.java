package eu.bilekpavel.vinotekalara.homepage.translator.internal.languages;

import eu.bilekpavel.vinotekalara.homepage.translator.internal.AbstractHomePageTranslator;
import org.springframework.stereotype.Component;

@Component
public final class SampleHomePageTranslator extends AbstractHomePageTranslator {

    public SampleHomePageTranslator() {
        super(
                "TITLE",
                "WELCOME_MESSAGE",
                "SHORT_DESCRIPTION"
        );
    }
}

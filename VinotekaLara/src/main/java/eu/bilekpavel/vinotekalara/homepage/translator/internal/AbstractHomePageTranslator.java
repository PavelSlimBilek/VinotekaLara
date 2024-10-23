package eu.bilekpavel.vinotekalara.homepage.translator.internal;

import eu.bilekpavel.vinotekalara.homepage.translator.HomePageTranslator;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class AbstractHomePageTranslator implements HomePageTranslator {
    private final String TITLE;
    private final String WELCOME_MESSAGE;
    private final String SHORT_DESCRIPTION;

    @Override
    public String title() {
        return TITLE;
    }

    @Override
    public String welcomeMessage() {
        return WELCOME_MESSAGE;
    }

    @Override
    public String shortDescription() {
        return SHORT_DESCRIPTION;
    }
}

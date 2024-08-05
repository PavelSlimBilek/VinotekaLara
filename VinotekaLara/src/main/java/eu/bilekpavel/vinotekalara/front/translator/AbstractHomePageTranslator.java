package eu.bilekpavel.vinotekalara.front.translator;

import eu.bilekpavel.vinotekalara.translator.Language;
import eu.bilekpavel.vinotekalara.translator.TranslatorInterface;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class AbstractHomePageTranslator implements TranslatorInterface, HomePageTranslatorInterface{

    private Language language;

    private final String TITLE;
    private final String WELCOME_MESSAGE;
    private final String DESCRIPTION;

    @Override
    public Language getLanguage() {
        return language;
    }

    @Override
    public String getTitle() {
        return TITLE;
    }
    @Override
    public String getWelcomeMessage() {
        return WELCOME_MESSAGE;
    }
    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
package eu.bilekpavel.vinotekalara.homepage.translator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class AbstractHomePageData implements HomePageTranslatorInterface {

    private final String TITLE;
    private final String WELCOME_MESSAGE;
    private final String DESCRIPTION;

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
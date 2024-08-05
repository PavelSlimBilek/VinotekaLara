package eu.bilekpavel.vinotekalara.front.translator;

import eu.bilekpavel.vinotekalara.translator.Language;

public interface HomePageTranslatorInterface {
    String getTitle();
    String getWelcomeMessage();
    String getDescription();
    Language getLanguage();
}
package eu.bilekpavel.vinotekalara.front.translator;

import eu.bilekpavel.vinotekalara.translator.dto.Language;

public interface HomePageTranslatorInterface {
    String getTitle();
    String getWelcomeMessage();
    String getDescription();
    Language getLanguage();
}
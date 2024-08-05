package eu.bilekpavel.vinotekalara.front;

import eu.bilekpavel.vinotekalara.front.dto.TranslatedHomePageContent;
import eu.bilekpavel.vinotekalara.front.translator.HomePageTranslatorInterface;

public interface HomePageContentProviderInterface {
    TranslatedHomePageContent getTranslatedContent(HomePageTranslatorInterface translator);
}
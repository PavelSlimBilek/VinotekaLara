package eu.bilekpavel.vinotekalara.homepage;

import eu.bilekpavel.vinotekalara.homepage.translator.dto.TranslatedHomePageContent;
import eu.bilekpavel.vinotekalara.homepage.translator.HomePageTranslatorInterface;

public interface HomePageContentProviderInterface {
    TranslatedHomePageContent getTranslatedContent(HomePageTranslatorInterface translator);
}
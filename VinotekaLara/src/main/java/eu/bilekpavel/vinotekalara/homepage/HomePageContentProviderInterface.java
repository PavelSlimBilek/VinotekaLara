package eu.bilekpavel.vinotekalara.homepage;

import eu.bilekpavel.vinotekalara.homepage.translator.dto.LocalizedHomePageContent;
import eu.bilekpavel.vinotekalara.homepage.translator.HomePageTranslatorInterface;

public interface HomePageContentProviderInterface {
    LocalizedHomePageContent getTranslatedContent(HomePageTranslatorInterface translator);
}
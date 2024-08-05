package eu.bilekpavel.vinotekalara.front;

import eu.bilekpavel.vinotekalara.front.dto.HomePageContent;
import eu.bilekpavel.vinotekalara.front.translator.HomePageTranslatorInterface;

public interface HomePageContentProviderInterface {
    HomePageContent getTranslatedContent(HomePageTranslatorInterface translator);
}
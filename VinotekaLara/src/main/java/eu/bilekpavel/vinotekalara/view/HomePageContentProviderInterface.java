package eu.bilekpavel.vinotekalara.view;

import eu.bilekpavel.vinotekalara.view.translator.dto.TranslatedHomePageContent;
import eu.bilekpavel.vinotekalara.view.translator.HomePageTranslatorInterface;

public interface HomePageContentProviderInterface {
    TranslatedHomePageContent getTranslatedContent(HomePageTranslatorInterface translator);
}
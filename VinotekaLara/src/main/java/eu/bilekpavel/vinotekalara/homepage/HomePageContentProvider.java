package eu.bilekpavel.vinotekalara.homepage;

import eu.bilekpavel.vinotekalara.homepage.translator.dto.TranslatedHomePageContent;
import eu.bilekpavel.vinotekalara.homepage.translator.HomePageTranslatorInterface;
import org.springframework.stereotype.Service;

@Service
public class HomePageContentProvider implements HomePageContentProviderInterface{
    @Override
    public TranslatedHomePageContent getTranslatedContent(HomePageTranslatorInterface translator) {
        return new TranslatedHomePageContent(
                translator.getTitle(),
                translator.getWelcomeMessage(),
                translator.getDescription()
        );
    }
}
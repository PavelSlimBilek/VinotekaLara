package eu.bilekpavel.vinotekalara.front;

import eu.bilekpavel.vinotekalara.front.dto.TranslatedHomePageContent;
import eu.bilekpavel.vinotekalara.front.translator.HomePageTranslatorInterface;
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
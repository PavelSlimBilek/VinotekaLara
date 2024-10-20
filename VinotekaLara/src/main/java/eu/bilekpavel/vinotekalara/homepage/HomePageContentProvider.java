package eu.bilekpavel.vinotekalara.homepage;

import eu.bilekpavel.vinotekalara.homepage.translator.dto.LocalizedHomePageContent;
import eu.bilekpavel.vinotekalara.homepage.translator.HomePageTranslatorInterface;
import org.springframework.stereotype.Service;

@Service
public class HomePageContentProvider implements HomePageContentProviderInterface{
    @Override
    public LocalizedHomePageContent getTranslatedContent(HomePageTranslatorInterface translator) {
        return new LocalizedHomePageContent(
                translator.getTitle(),
                translator.getWelcomeMessage(),
                translator.getDescription()
        );
    }
}
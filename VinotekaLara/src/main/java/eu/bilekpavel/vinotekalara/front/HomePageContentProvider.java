package eu.bilekpavel.vinotekalara.front;

import eu.bilekpavel.vinotekalara.front.dto.HomePageContent;
import eu.bilekpavel.vinotekalara.front.translator.HomePageTranslatorInterface;
import eu.bilekpavel.vinotekalara.translator.LanguageMapper;
import org.springframework.stereotype.Service;

@Service
public class HomePageContentProvider implements HomePageContentProviderInterface{
    @Override
    public HomePageContent getTranslatedContent(HomePageTranslatorInterface translator) {
        return new HomePageContent(
                LanguageMapper.getLanguageAbbreviation(translator.getLanguage()),
                translator.getTitle(),
                translator.getWelcomeMessage(),
                translator.getDescription()
        );
    }
}
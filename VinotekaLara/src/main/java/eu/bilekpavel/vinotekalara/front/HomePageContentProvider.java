package eu.bilekpavel.vinotekalara.front;

import eu.bilekpavel.vinotekalara.front.dto.TranslatedHomePageContent;
import eu.bilekpavel.vinotekalara.front.translator.HomePageTranslatorInterface;
import eu.bilekpavel.vinotekalara.translator.LanguageMapper;
import org.springframework.stereotype.Service;

@Service
public class HomePageContentProvider implements HomePageContentProviderInterface{
    @Override
    public TranslatedHomePageContent getTranslatedContent(HomePageTranslatorInterface translator) {
        return new TranslatedHomePageContent(
                LanguageMapper.getLanguageAbbreviation(translator.getLanguage()),
                translator.getTitle(),
                translator.getWelcomeMessage(),
                translator.getDescription()
        );
    }
}
package eu.bilekpavel.vinotekalara.homepage.translator.internal;

import eu.bilekpavel.vinotekalara.homepage.translator.HomePageTranslator;
import eu.bilekpavel.vinotekalara.homepage.translator.HomePageTranslatorDataFactoryInterface;
import eu.bilekpavel.vinotekalara.homepage.translator.dto.HomePageTranslatorData;
import org.springframework.stereotype.Component;

@Component
public final class HomePageTranslatorDataFactory implements HomePageTranslatorDataFactoryInterface {
    @Override
    public HomePageTranslatorData create(HomePageTranslator locale) {
        return new HomePageTranslatorData(
                locale.title(),
                locale.welcomeMessage(),
                locale.shortDescription()
        );
    }
}

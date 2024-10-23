package eu.bilekpavel.vinotekalara.homepage.translator;

import eu.bilekpavel.vinotekalara.homepage.translator.dto.HomePageTranslatorData;

public interface HomePageTranslatorDataFactoryInterface {
    public HomePageTranslatorData create(HomePageTranslator locale);
}

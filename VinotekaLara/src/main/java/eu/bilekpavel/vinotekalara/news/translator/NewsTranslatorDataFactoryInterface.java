package eu.bilekpavel.vinotekalara.news.translator;

import eu.bilekpavel.vinotekalara.news.translator.dto.NewsTranslatorData;

public interface NewsTranslatorDataFactoryInterface {
    NewsTranslatorData create(NewsTranslator locale);
}

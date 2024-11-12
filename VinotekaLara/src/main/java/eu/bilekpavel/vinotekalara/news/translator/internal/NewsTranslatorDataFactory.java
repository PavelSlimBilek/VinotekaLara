package eu.bilekpavel.vinotekalara.news.translator.internal;

import eu.bilekpavel.vinotekalara.news.translator.NewsTranslator;
import eu.bilekpavel.vinotekalara.news.translator.NewsTranslatorDataFactoryInterface;
import eu.bilekpavel.vinotekalara.news.translator.dto.NewsTranslatorData;
import org.springframework.stereotype.Component;

@Component
public class NewsTranslatorDataFactory implements NewsTranslatorDataFactoryInterface {
    @Override
    public NewsTranslatorData create(NewsTranslator locale) {
        return new NewsTranslatorData(
                locale.news(),
                locale.publish(),
                locale.hide()
        );
    }
}

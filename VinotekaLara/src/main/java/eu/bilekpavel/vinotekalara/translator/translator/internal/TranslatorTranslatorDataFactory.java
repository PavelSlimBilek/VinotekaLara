package eu.bilekpavel.vinotekalara.translator.translator.internal;

import eu.bilekpavel.vinotekalara.translator.translator.TranslatorTranslator;
import eu.bilekpavel.vinotekalara.translator.translator.TranslatorTranslatorDataFactoryInterface;
import eu.bilekpavel.vinotekalara.translator.translator.dto.TranslatorTranslatorData;
import org.springframework.stereotype.Component;

@Component
public final class TranslatorTranslatorDataFactory implements TranslatorTranslatorDataFactoryInterface {

    @Override
    public TranslatorTranslatorData create(TranslatorTranslator locale) {
        return new TranslatorTranslatorData(
                locale.language(),
                locale.languages(),
                locale.supportedLanguages(),
                locale.allowedLanguages(),
                locale.selectDefaultLanguage(),
                locale.toggleLanguages(),
                locale.updateLocalizations()
        );
    }
}

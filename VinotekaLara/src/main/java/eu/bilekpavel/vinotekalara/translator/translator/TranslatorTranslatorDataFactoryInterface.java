package eu.bilekpavel.vinotekalara.translator.translator;

import eu.bilekpavel.vinotekalara.translator.translator.dto.TranslatorTranslatorData;

public interface TranslatorTranslatorDataFactoryInterface {
    TranslatorTranslatorData create(TranslatorTranslator locale);
}

package eu.bilekpavel.vinotekalara.translator;

import eu.bilekpavel.vinotekalara.translator.dto.TranslatorData;

public interface TranslatorDataFactoryInterface {
    TranslatorData create(Translator translator);
}

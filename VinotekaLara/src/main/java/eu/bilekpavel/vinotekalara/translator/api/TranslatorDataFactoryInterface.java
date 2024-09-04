package eu.bilekpavel.vinotekalara.translator.api;

import eu.bilekpavel.vinotekalara.translator.dto.TranslatorData;

public interface TranslatorDataFactoryInterface {
    TranslatorData create(Translator translator);
}

package eu.bilekpavel.vinotekalara.app.translator;

import eu.bilekpavel.vinotekalara.app.translator.dto.CoreTranslatorData;

public interface CoreTranslatorDataFactoryInterface {
    CoreTranslatorData create(CoreTranslator locale);
}

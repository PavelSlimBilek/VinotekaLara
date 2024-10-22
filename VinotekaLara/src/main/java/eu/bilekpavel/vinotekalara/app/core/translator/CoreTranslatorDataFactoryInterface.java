package eu.bilekpavel.vinotekalara.app.core.translator;

import eu.bilekpavel.vinotekalara.app.core.translator.dto.CoreTranslatorData;

public interface CoreTranslatorDataFactoryInterface {
    CoreTranslatorData create(CoreTranslator locale);
}

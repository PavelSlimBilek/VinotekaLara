package eu.bilekpavel.vinotekalara.app.module.color.translator;

import eu.bilekpavel.vinotekalara.app.module.color.translator.dto.CoreColorTranslatorData;

public interface CoreColorTranslatorDataFactoryInterface {
    CoreColorTranslatorData create(CoreColorTranslator locale);
}

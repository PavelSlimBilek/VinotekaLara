package eu.bilekpavel.vinotekalara.app.module.color.translator.internal;

import eu.bilekpavel.vinotekalara.app.module.color.translator.CoreColorTranslator;
import eu.bilekpavel.vinotekalara.app.module.color.translator.CoreColorTranslatorDataFactoryInterface;
import eu.bilekpavel.vinotekalara.app.module.color.translator.dto.CoreColorTranslatorData;
import org.springframework.stereotype.Component;

@Component
public final class CoreColorTranslatorDataFactory implements CoreColorTranslatorDataFactoryInterface {

    @Override
    public CoreColorTranslatorData create(CoreColorTranslator locale) {
        return new CoreColorTranslatorData(
                locale.red(),
                locale.green(),
                locale.blue()
        );
    }
}

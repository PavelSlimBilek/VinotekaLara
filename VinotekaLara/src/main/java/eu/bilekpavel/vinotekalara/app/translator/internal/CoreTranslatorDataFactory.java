package eu.bilekpavel.vinotekalara.app.translator.internal;

import eu.bilekpavel.vinotekalara.app.translator.CoreTranslator;
import eu.bilekpavel.vinotekalara.app.translator.CoreTranslatorDataFactoryInterface;
import eu.bilekpavel.vinotekalara.app.translator.dto.CoreTranslatorData;
import org.springframework.stereotype.Component;

@Component
public final class CoreTranslatorDataFactory implements CoreTranslatorDataFactoryInterface {
    @Override
    public CoreTranslatorData create(CoreTranslator locale) {
        return new CoreTranslatorData(
                locale.application(),
                locale.settings(),
                locale.preview(),
                locale.name(),
                locale.allow(),
                locale.allowed(),
                locale.forbid(),
                locale.forbidden(),
                locale.activate(),
                locale.submit(),
                locale.edit(),
                locale.back(),
                locale.delete(),
                locale.create(),
                locale.apply(),
                locale.translator()
        );
    }
}

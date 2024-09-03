package eu.bilekpavel.vinotekalara.translator;

import eu.bilekpavel.vinotekalara.translator.dto.TranslatorData;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TranslatorDataFactory implements TranslatorDataFactoryInterface {

    private TranslatorRegistryInterface registry;

    @Override
    public TranslatorData create(Translator translator) {
        return new TranslatorData(
            translator.getCode(),
            registry.getSupported()
        );
    }
}

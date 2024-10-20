package eu.bilekpavel.vinotekalara.translator.impl;

import eu.bilekpavel.vinotekalara.app.config.AppConfig;
import eu.bilekpavel.vinotekalara.translator.api.Translator;
import eu.bilekpavel.vinotekalara.translator.api.TranslatorDataFactoryInterface;
import eu.bilekpavel.vinotekalara.translator.api.TranslatorRegistryInterface;
import eu.bilekpavel.vinotekalara.translator.dto.TranslatorData;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TranslatorDataFactory implements TranslatorDataFactoryInterface {

    private TranslatorRegistryInterface registry;
    private AppConfig config;

    @Override
    public TranslatorData create(Translator translator) {
        return new TranslatorData(
            translator.getCode(),
            registry.getSupported(),
            config.getAllowed()
        );
    }
}

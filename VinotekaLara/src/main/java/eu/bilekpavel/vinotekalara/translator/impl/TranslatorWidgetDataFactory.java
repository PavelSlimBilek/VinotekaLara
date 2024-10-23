package eu.bilekpavel.vinotekalara.translator.impl;

import eu.bilekpavel.vinotekalara.app.config.AppConfig;
import eu.bilekpavel.vinotekalara.translator.api.Translator;
import eu.bilekpavel.vinotekalara.translator.api.TranslatorWidgetDataFactoryInterface;
import eu.bilekpavel.vinotekalara.translator.api.TranslatorRegistryInterface;
import eu.bilekpavel.vinotekalara.translator.dto.TranslatorWidgetData;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public final class TranslatorWidgetDataFactory implements TranslatorWidgetDataFactoryInterface {

    private TranslatorRegistryInterface registry;
    private AppConfig config;

    @Override
    public TranslatorWidgetData create(Translator translator) {
        return new TranslatorWidgetData(
            translator.getCode(),
            translator.getLang(),
            registry.getSupported(),
            config.getAllowed()
        );
    }
}

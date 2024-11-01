package eu.bilekpavel.vinotekalara.translator.internal;

import eu.bilekpavel.vinotekalara.app.config.TranslatorConfig;
import eu.bilekpavel.vinotekalara.translator.api.Translator;
import eu.bilekpavel.vinotekalara.translator.api.TranslatorWidgetDataFactoryInterface;
import eu.bilekpavel.vinotekalara.translator.api.TranslatorRegistryInterface;
import eu.bilekpavel.vinotekalara.translator.dto.TranslatorWidgetData;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public final class TranslatorWidgetDataFactory implements TranslatorWidgetDataFactoryInterface {

    @Override
    public TranslatorWidgetData create(Translator currentTranslator, TranslatorConfig config, TranslatorRegistryInterface registry) {
        return new TranslatorWidgetData(
            currentTranslator.getLang(),
            registry.getAll(),
            config.getAllowed(),
            registry.getAll().stream().map(Translator::getLang).toList()
        );
    }
}

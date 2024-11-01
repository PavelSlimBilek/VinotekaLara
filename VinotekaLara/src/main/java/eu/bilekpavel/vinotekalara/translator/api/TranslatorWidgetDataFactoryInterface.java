package eu.bilekpavel.vinotekalara.translator.api;

import eu.bilekpavel.vinotekalara.app.config.TranslatorConfig;
import eu.bilekpavel.vinotekalara.translator.dto.TranslatorWidgetData;

public interface TranslatorWidgetDataFactoryInterface {
    TranslatorWidgetData create(Translator translator, TranslatorConfig config, TranslatorRegistryInterface registry);
}

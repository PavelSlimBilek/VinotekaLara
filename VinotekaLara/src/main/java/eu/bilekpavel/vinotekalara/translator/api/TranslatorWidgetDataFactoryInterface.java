package eu.bilekpavel.vinotekalara.translator.api;

import eu.bilekpavel.vinotekalara.app.config.AppConfig;
import eu.bilekpavel.vinotekalara.translator.dto.TranslatorWidgetData;

public interface TranslatorWidgetDataFactoryInterface {
    TranslatorWidgetData create(Translator translator, AppConfig config, TranslatorRegistryInterface registry);
}

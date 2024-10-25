package eu.bilekpavel.vinotekalara.app.translator.service;

import eu.bilekpavel.vinotekalara.app.config.AppConfig;
import eu.bilekpavel.vinotekalara.translator.api.Translator;
import eu.bilekpavel.vinotekalara.translator.api.TranslatorRegistryInterface;
import eu.bilekpavel.vinotekalara.translator.api.TranslatorWidgetDataFactoryInterface;
import eu.bilekpavel.vinotekalara.translator.dto.TranslatorWidgetData;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TranslatorService implements TranslatorServiceInterface {

    private final TranslatorRegistryInterface registry;
    private final TranslatorWidgetDataFactoryInterface widgetDataProvider;
    private final AppConfig config;

    @Override
    public Translator getLocale(String langCode) {
        return get(langCode);
    }

    @Override
    public TranslatorWidgetData getTranslatorWidgetData(Translator locale) {
        return widgetDataProvider.create(locale, config, registry);
    }

    @Override
    public void setDefaultTranslator(Language language) {
        config.setDefaultLanguage(language);
    }

    @Override
    public Translator toggleTranslator(String langCode) {
        if (isValidTranslatorCode(langCode) && config.getDefaultLanguage() != Language.fromLangCode(langCode)) {
            config.toggle(Language.fromLangCode(langCode));
        }
        return get(langCode);
    }

    private Translator get(String langCode) {
        if (isValidTranslatorCode(langCode)) {
            return registry.getLocale(langCode);
        }
        return registry.getLocale(config.getDefaultLanguage().getCode());
    }

    private boolean isValidTranslatorCode(String langCode) {
        return langCode != null && !langCode.isEmpty() && registry.isOnTheList(langCode);
    }
}

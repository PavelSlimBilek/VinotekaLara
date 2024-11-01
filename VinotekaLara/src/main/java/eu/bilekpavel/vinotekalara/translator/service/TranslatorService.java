package eu.bilekpavel.vinotekalara.translator.service;

import eu.bilekpavel.vinotekalara.app.config.TranslatorConfig;
import eu.bilekpavel.vinotekalara.translator.api.Translator;
import eu.bilekpavel.vinotekalara.translator.api.TranslatorRegistryInterface;
import eu.bilekpavel.vinotekalara.translator.api.TranslatorWidgetDataFactoryInterface;
import eu.bilekpavel.vinotekalara.translator.dto.TranslatorWidgetData;
import eu.bilekpavel.vinotekalara.translator.error.CannotForbidDefaultLanguageTranslatorException;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import eu.bilekpavel.vinotekalara.translator.translator.TranslatorTranslator;
import eu.bilekpavel.vinotekalara.translator.translator.TranslatorTranslatorDataFactoryInterface;
import eu.bilekpavel.vinotekalara.translator.translator.dto.TranslatorTranslatorData;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TranslatorService implements TranslatorServiceInterface {

    private final TranslatorConfig config;
    private final TranslatorRegistryInterface registry;

    private final TranslatorWidgetDataFactoryInterface widgetDataProvider;
    private final TranslatorTranslatorDataFactoryInterface translatorLocalizationDataProvider;

    @Override
    public Translator getLocale(String langCode) {
        return get(langCode);
    }

    @Override
    public TranslatorWidgetData getTranslatorWidgetData(Translator locale) {
        return widgetDataProvider.create(locale, config, registry);
    }

    @Override
    public TranslatorTranslatorData getTranslatorTranslatorData(TranslatorTranslator locale) {
        return translatorLocalizationDataProvider.create(locale);
    }

    @Override
    public void setDefaultTranslator(Language language) {
        config.setDefaultLanguage(language);
    }

    @Override
    public Translator toggleTranslator(String langCode) {
        if (!isValidTranslatorCode(langCode) || config.getDefaultLanguage() == Language.fromLangCode(langCode)) {
            throw new CannotForbidDefaultLanguageTranslatorException();
        } else {
            config.toggle(Language.fromLangCode(langCode));
            return get(langCode);
        }
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

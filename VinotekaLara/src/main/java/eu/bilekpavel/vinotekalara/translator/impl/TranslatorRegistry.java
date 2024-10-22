package eu.bilekpavel.vinotekalara.translator.impl;

import eu.bilekpavel.vinotekalara.app.config.AppConfig;
import eu.bilekpavel.vinotekalara.translator.api.Translator;
import eu.bilekpavel.vinotekalara.translator.api.TranslatorRegistryInterface;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import eu.bilekpavel.vinotekalara.translator.language.languages.*;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TranslatorRegistry implements TranslatorRegistryInterface {

    private final Map<String, Translator> LOCALES;
    private final AppConfig config;

    public TranslatorRegistry(
            AppConfig config,
            Czech czech,
            English english,
            German german,
            Ukrainian ukrainian,
            French french
    ) {
        Map<String, Translator>locales = new HashMap<>();
        locales.put(czech.getLang().getCode(), czech);
        locales.put(english.getLang().getCode(), english);
        locales.put(german.getLang().getCode(), german);
        locales.put(ukrainian.getLang().getCode(), ukrainian);
        locales.put(french.getLang().getCode(), french);

        LOCALES = Collections.unmodifiableMap(locales);
        this.config = config;
    }

    @Override
    public Translator getLocale(String langCode) {
        return isOnTheList(langCode) ? LOCALES.get(langCode) : LOCALES.get(config.getDEFAULT().getCode());
    }

    @Override
    public List<Language> getAllowedLanguages() {
        return LOCALES.values().stream()
                .map(Translator::getLang)
                .filter(lang -> config.getAllowed().contains(lang))
                .toList();
    }

    @Override
    public boolean isOnTheList(String langCode) {
        return LOCALES.containsKey(langCode);
    }

    @Override
    public List<Translator> getSupported() {
        return LOCALES.values().stream()
                .filter(t -> config.isAllowed(t.getLang()))
                .toList();
    }
}

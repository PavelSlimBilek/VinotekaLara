package eu.bilekpavel.vinotekalara.translator.impl;

import eu.bilekpavel.vinotekalara.translator.api.Translator;
import eu.bilekpavel.vinotekalara.translator.api.TranslatorRegistryInterface;
import eu.bilekpavel.vinotekalara.translator.language.languages.Czech;
import eu.bilekpavel.vinotekalara.translator.language.languages.English;
import eu.bilekpavel.vinotekalara.translator.language.languages.German;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TranslatorRegistry implements TranslatorRegistryInterface {

    private final Map<String, Translator> LOCALES;
    private final Translator DEFAULT; // settable fallback

    public TranslatorRegistry(
            Czech czech,
            English english,
            German german
    ) {
        Map<String, Translator>locales = new HashMap<>();
        locales.put(czech.getLang().getCode(), czech);
        locales.put(english.getLang().getCode(), english);
        locales.put(german.getLang().getCode(), german.allow(false));

        DEFAULT = czech;
        LOCALES = Collections.unmodifiableMap(locales);
    }

    @Override
    public Translator getLocale(String langCode) {
        return isOnTheList(langCode)
                ? LOCALES.get(langCode)
                : DEFAULT;
    }

    @Override
    public boolean isOnTheList(String langCode) {
        return LOCALES.containsKey(langCode);
    }

    @Override
    public List<Translator> getSupported() {
        return LOCALES.values().stream()
                .filter(Translator::isAllowed)
                .toList();
    }
}
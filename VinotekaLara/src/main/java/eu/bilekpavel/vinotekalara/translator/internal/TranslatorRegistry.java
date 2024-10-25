package eu.bilekpavel.vinotekalara.translator.internal;

import eu.bilekpavel.vinotekalara.translator.api.Translator;
import eu.bilekpavel.vinotekalara.translator.api.TranslatorRegistryInterface;
import eu.bilekpavel.vinotekalara.translator.language.languages.*;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public final class TranslatorRegistry implements TranslatorRegistryInterface {

    private final Map<String, Translator> locales;

    public TranslatorRegistry(
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

        this.locales = Collections.unmodifiableMap(locales);
    }

    @Override
    public boolean isOnTheList(String langCode) {
        return locales.containsKey(langCode);
    }

    @Override
    public List<Translator> getAll() {
        return locales.values().stream().toList();
    }

    @Override
    public Translator getLocale(String langCode) {
        return locales.get(langCode);
    }
}

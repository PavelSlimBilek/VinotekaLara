package eu.bilekpavel.vinotekalara.translator;

import eu.bilekpavel.vinotekalara.translator.dto.TranslatorData;
import eu.bilekpavel.vinotekalara.translator.language.languages.Czech;
import eu.bilekpavel.vinotekalara.translator.language.languages.English;
import eu.bilekpavel.vinotekalara.translator.language.languages.German;
import lombok.NonNull;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class TranslatorRegistry {

    private final Map<String, Translator> LOCALES;
    private final Translator DEFAULT;

    public TranslatorRegistry(
            Czech czech,
            English english,
            German german
    ) {
        Map<String, Translator>locales = new HashMap<>();
        locales.put(czech.language.getCode(), czech);
        locales.put(english.language.getCode(), english);
        locales.put(german.language.getCode(), german);

        DEFAULT = czech;
        LOCALES = Collections.unmodifiableMap(locales);
    }

    public Translator getLocale(String lang) {
        return isOnTheList(lang) ? LOCALES.get(lang) : this.DEFAULT;
    }

    // TODO create service and inject Registry into that .. then move this method
    public TranslatorData getData(@NonNull Translator locale) {
        return new TranslatorData(
                locale.getCode(),
                getSupported()
        );
    }

    public boolean isOnTheList(String code) {
        return LOCALES.containsKey(code);
    }

    private List<Translator> getSupported() {
        return LOCALES.values().stream().toList();
    }
}
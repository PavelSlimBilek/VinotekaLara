package eu.bilekpavel.vinotekalara.translator;

import eu.bilekpavel.vinotekalara.translator.dto.TranslatorData;
import eu.bilekpavel.vinotekalara.translator.language.languages.Czech;
import eu.bilekpavel.vinotekalara.translator.language.languages.English;
import eu.bilekpavel.vinotekalara.translator.language.languages.German;
import lombok.NonNull;
import org.springframework.context.annotation.Configuration;

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
        LOCALES = new HashMap<>();
        LOCALES.put(czech.code, czech);
        LOCALES.put(english.code, english);
        LOCALES.put(german.code, german);

        DEFAULT = czech;
    }

    public Translator getLocale(String lang) {
        return isOnTheList(lang) ? LOCALES.get(lang) : this.DEFAULT;
    }

    public TranslatorData getData(@NonNull Translator locale) {
        return new TranslatorData(
                locale.getCode(),
                getSupported()
        );
    }

    private List<Translator> getSupported() {
        return LOCALES.values().stream().toList();
    }

    private boolean isOnTheList(String code) {
        return LOCALES.containsKey(code);
    }
}
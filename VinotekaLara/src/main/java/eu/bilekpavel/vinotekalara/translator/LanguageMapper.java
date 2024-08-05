package eu.bilekpavel.vinotekalara.translator;

import eu.bilekpavel.vinotekalara.translator.dto.Language;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public final class LanguageMapper {

    private static final Map<String, Language> SUPPORTED_LANGUAGES = new HashMap<>();

    static {
        SUPPORTED_LANGUAGES.put("cs", Language.CZECH);
        SUPPORTED_LANGUAGES.put("en", Language.ENGLISH);
        SUPPORTED_LANGUAGES.put("de", Language.GERMAN);
    }

    public static Language getLanguage(String lang) {
        return SUPPORTED_LANGUAGES.get(lang);
    }

    public static boolean isOnList(String lang) {
        return SUPPORTED_LANGUAGES.containsKey(lang);
    }

    public static String getLanguageAbbreviation(Language lang) {
        return SUPPORTED_LANGUAGES.entrySet().stream()
                .filter(entry -> entry.getValue().equals(lang))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    public static List<Language> getSupportedLanguages() {
        return SUPPORTED_LANGUAGES.values().stream().toList();
    }
}
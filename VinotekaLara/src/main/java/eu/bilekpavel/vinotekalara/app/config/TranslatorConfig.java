package eu.bilekpavel.vinotekalara.app.config;

import eu.bilekpavel.vinotekalara.translator.language.Language;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
@Getter
public class TranslatorConfig {

    @Setter
    private Language defaultLanguage;
    private final Map<String, Language> allowedLanguages;

    public TranslatorConfig() {
        defaultLanguage = Language.CZECH;
        allowedLanguages = new HashMap<>();

        allowedLanguages.put(defaultLanguage.getCode(), defaultLanguage);
    }

    public List<Language> getAllowed() {
        return new ArrayList<>(allowedLanguages.values());
    }

    public boolean isAllowed(String code) {
        return allowedLanguages.containsKey(code);
    }

    public boolean isAllowed(Language language) {
        return allowedLanguages.containsValue(language);
    }

    public void toggle(Language language) {
        if (!allowedLanguages.containsKey(language.getCode())) {
            allowedLanguages.put(language.getCode(), language);
        } else {
            allowedLanguages.remove(language.getCode());
        }
    }
}

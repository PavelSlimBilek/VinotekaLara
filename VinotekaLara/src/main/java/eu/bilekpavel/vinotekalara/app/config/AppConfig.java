package eu.bilekpavel.vinotekalara.app.config;

import eu.bilekpavel.vinotekalara.translator.language.Language;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
@Getter
public class AppConfig {

    @Setter
    private Language defaultLanguage = null;

    private final Map<String, Language> allowedLanguages = new HashMap<>();

    public void removeLanguage(Language language) {
        allowedLanguages.remove(language.name());
    }

    public void addLanguage(Language language) {
        allowedLanguages.put(language.name(), language);
    }
}

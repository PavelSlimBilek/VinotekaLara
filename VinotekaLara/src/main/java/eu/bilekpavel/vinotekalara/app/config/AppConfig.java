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
    private Language defaultLanguage = Language.CZECH;

    private final Map<String, Language> ALLOWED = new HashMap<>();

    public List<Language> getAllowed() {
        return new ArrayList<>(ALLOWED.values());
    }

    public boolean isAllowed(String code) {
        return ALLOWED.containsKey(code);
    }

    public boolean isAllowed(Language language) {
        return ALLOWED.containsValue(language);
    }

    public void toggle(Language language) {
        if (!ALLOWED.containsKey(language.getCode())) {
            ALLOWED.put(language.getCode(), language);
        } else {
            ALLOWED.remove(language.getCode());
        }
    }
}

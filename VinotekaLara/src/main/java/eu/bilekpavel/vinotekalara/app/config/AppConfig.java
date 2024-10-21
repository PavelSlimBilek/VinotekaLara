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
    private Language DEFAULT = null;

    private final Map<String, Language> ALLOWED = new HashMap<>();

    public List<Language> getAllowed() {
        return new ArrayList<>(ALLOWED.values());
    }


    public void allow(Language language) {
        ALLOWED.put(language.getCode(), language);
    }

    public void forbid(Language language) {
        ALLOWED.remove(language.getCode());
    }

    public boolean isAllowed(String code) {
        return ALLOWED.containsKey(code);
    }

    public boolean isAllowed(Language language) {
        return ALLOWED.containsValue(language);
    }
}

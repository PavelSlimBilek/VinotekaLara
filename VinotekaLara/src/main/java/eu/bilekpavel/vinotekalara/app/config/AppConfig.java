package eu.bilekpavel.vinotekalara.app.config;

import eu.bilekpavel.vinotekalara.translator.language.Language;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Getter
@Setter
public class AppConfig {
    private List<Language> allowedLanguages;
    private Language defaultLanguage;

    public AppConfig() {
        allowedLanguages = new ArrayList<>();
        defaultLanguage = Language.CZECH;
    }
}

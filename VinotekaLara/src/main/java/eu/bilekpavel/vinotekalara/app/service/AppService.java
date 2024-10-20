package eu.bilekpavel.vinotekalara.app.service;

import eu.bilekpavel.vinotekalara.app.config.AppConfig;
import eu.bilekpavel.vinotekalara.translator.api.Translator;
import eu.bilekpavel.vinotekalara.translator.dto.LanguageWidgetData;
import eu.bilekpavel.vinotekalara.translator.impl.TranslatorRegistry;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppService implements AppServiceInterface {
    private TranslatorRegistry translatorRegistry;
    private AppConfig config;

    public LanguageWidgetData getLanguageWidgetData() {
        return new LanguageWidgetData(
                translatorRegistry.getSupported().stream().map(Translator::getLang).toList(),
                config.getDefaultLanguage());
    }

    public void setDefaultLanguage(Language language) {
        config.setDefaultLanguage(language);
    }
}

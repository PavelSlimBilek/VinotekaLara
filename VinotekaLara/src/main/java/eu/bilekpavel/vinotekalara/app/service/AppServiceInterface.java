package eu.bilekpavel.vinotekalara.app.service;

import eu.bilekpavel.vinotekalara.translator.dto.LanguageWidgetData;
import eu.bilekpavel.vinotekalara.translator.language.Language;

public interface AppServiceInterface {
    LanguageWidgetData getLanguageWidgetData();
    void setDefaultLanguage(Language lang);
}
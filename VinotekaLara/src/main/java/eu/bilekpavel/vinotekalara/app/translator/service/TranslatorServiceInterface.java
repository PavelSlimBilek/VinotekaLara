package eu.bilekpavel.vinotekalara.app.translator.service;

import eu.bilekpavel.vinotekalara.translator.api.Translator;
import eu.bilekpavel.vinotekalara.translator.dto.TranslatorWidgetData;
import eu.bilekpavel.vinotekalara.translator.language.Language;

public interface TranslatorServiceInterface {
    Translator getLocale(String langCode);
    TranslatorWidgetData getTranslatorWidgetData(Translator locale);
    void setDefaultTranslator(Language language);
    Translator toggleTranslator(String langCode);
}

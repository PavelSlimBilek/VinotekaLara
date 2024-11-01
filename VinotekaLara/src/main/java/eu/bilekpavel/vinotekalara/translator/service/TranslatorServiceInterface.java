package eu.bilekpavel.vinotekalara.translator.service;

import eu.bilekpavel.vinotekalara.translator.api.Translator;
import eu.bilekpavel.vinotekalara.translator.dto.TranslatorWidgetData;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import eu.bilekpavel.vinotekalara.translator.translator.TranslatorTranslator;
import eu.bilekpavel.vinotekalara.translator.translator.dto.TranslatorTranslatorData;

public interface TranslatorServiceInterface {
    Translator getLocale(String langCode);
    void setDefaultTranslator(Language language);
    Translator toggleTranslator(String langCode);

    TranslatorWidgetData getTranslatorWidgetData(Translator locale);
    TranslatorTranslatorData getTranslatorTranslatorData(TranslatorTranslator locale);
}

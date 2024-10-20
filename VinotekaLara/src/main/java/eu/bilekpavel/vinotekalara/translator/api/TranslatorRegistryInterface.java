package eu.bilekpavel.vinotekalara.translator.api;

import eu.bilekpavel.vinotekalara.translator.language.Language;

import java.util.List;

public interface TranslatorRegistryInterface {
    boolean isOnTheList(String langCode);
    List<Translator> getSupported();
    Translator getLocale(String langCode);
    List<Language> getAllowedLanguages();
}

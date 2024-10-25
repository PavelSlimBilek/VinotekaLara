package eu.bilekpavel.vinotekalara.translator.api;

import java.util.List;

public interface TranslatorRegistryInterface {
    boolean isOnTheList(String langCode);
    List<Translator> getAll();
    Translator getLocale(String langCode);
}

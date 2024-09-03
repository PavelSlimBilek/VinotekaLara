package eu.bilekpavel.vinotekalara.translator;

import java.util.List;

public interface TranslatorRegistryInterface {
    boolean isOnTheList(String langCode);
    List<Translator> getSupported();
    Translator getLocale(String langCode);
}

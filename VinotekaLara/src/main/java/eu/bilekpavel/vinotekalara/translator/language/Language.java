package eu.bilekpavel.vinotekalara.translator.language;

import eu.bilekpavel.vinotekalara.translator.error.InvalidLangCodeTranslatorException;
import lombok.Getter;

@Getter
public enum Language {

    CZECH("cz", "česky"),
    ENGLISH("en", "english"),
    GERMAN("de", "deutsch"),
    UKRAINIAN("uk", "український"),
    FRENCH("fr", "français");

    private final String code;
    private final String selfName;

    Language(String code, String selfName) {
        this.code = code;
        this.selfName = selfName;
    }

    public static Language fromLangCode(String langCode) {
        for (Language lang : Language.values()) {
            if (lang.getCode().equalsIgnoreCase(langCode)) {
                return lang;
            }
        }
        throw new InvalidLangCodeTranslatorException(langCode);
    }
}


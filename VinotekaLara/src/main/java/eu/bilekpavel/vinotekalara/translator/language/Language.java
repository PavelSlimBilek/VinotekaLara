package eu.bilekpavel.vinotekalara.translator.language;

import lombok.Getter;

@Getter
public enum Language {

    CZECH("cz", "česky"),
    ENGLISH("en", "english"),
    GERMAN("de", "deutsch"),
    UKRAINIAN("uk", "український");

    private final String code;
    private final String selfName;

    Language(String code, String selfName) {
        this.code = code;
        this.selfName = selfName;
    }
}
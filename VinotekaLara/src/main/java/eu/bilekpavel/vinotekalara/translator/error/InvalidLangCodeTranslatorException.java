package eu.bilekpavel.vinotekalara.translator.error;

public class InvalidLangCodeTranslatorException extends TranslatorException {
    public InvalidLangCodeTranslatorException(String langCode) {
        super("Invalid language code: " + langCode);
    }
}

package eu.bilekpavel.vinotekalara.translator.translator;

public interface TranslatorTranslator {
    String language();
    String languages();
    String supportedLanguages();
    String allowedLanguages();
    String selectDefaultLanguage();
    String toggleLanguage();
}

package eu.bilekpavel.vinotekalara.translator.error;

public abstract class TranslatorException extends RuntimeException {

    public TranslatorException(String message) {
        super(message);
    }
}

package eu.bilekpavel.vinotekalara.translator.error;

public class LocalizedStringValidationError extends RuntimeException {

    public LocalizedStringValidationError(String message) {
        super(message);
    }
}

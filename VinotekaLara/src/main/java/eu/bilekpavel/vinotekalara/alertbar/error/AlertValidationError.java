package eu.bilekpavel.vinotekalara.alertbar.error;

public class AlertValidationError extends RuntimeException {

    public AlertValidationError(String message) {
        super(message);
    }
}
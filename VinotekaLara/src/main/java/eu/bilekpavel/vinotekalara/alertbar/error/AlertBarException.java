package eu.bilekpavel.vinotekalara.alertbar.error;

public abstract class AlertBarException extends RuntimeException {
    public AlertBarException(String message) {
        super(message);
    }
}

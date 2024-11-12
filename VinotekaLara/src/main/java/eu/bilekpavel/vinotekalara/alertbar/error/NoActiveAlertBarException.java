package eu.bilekpavel.vinotekalara.alertbar.error;

public final class NoActiveAlertBarException extends AlertBarException {
    public NoActiveAlertBarException() {
        super("No active alert bar");
    }
}

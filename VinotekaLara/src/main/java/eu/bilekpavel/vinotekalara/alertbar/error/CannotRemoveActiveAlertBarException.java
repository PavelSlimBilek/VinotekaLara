package eu.bilekpavel.vinotekalara.alertbar.error;

public final class CannotRemoveActiveAlertBarException extends AlertBarException {

    public CannotRemoveActiveAlertBarException() {
        super("Cannot remove an active alert bar");
    }
}

package eu.bilekpavel.vinotekalara.alertbar.error;

public final class AlertBarNotFoundException extends AlertBarException{
    public AlertBarNotFoundException(String id) {
        super(String.format("Alert bar id:%s not found", id));
    }
}

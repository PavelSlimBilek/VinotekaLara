package eu.bilekpavel.vinotekalara.news.error;

public class CannotRemoveActiveNewsException extends NewsException {
    public CannotRemoveActiveNewsException() {
        super("Cannot remove active news");
    }
}

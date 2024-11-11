package eu.bilekpavel.vinotekalara.news.error;

public abstract class NewsException extends RuntimeException {
    public NewsException(String message) {
        super(message);
    }
}

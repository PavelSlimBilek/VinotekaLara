package eu.bilekpavel.vinotekalara.news.error;

public class NewsNotFoundException extends NewsException {
    public NewsNotFoundException(String id) {
        super("News id:'" + id + "' not found");
    }
}

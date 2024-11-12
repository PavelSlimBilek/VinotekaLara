package eu.bilekpavel.vinotekalara.news.error;

public class NewsNotRemovedException extends NewsException {
    public NewsNotRemovedException(String id) {
        super("News id:" + id + " not removed");
    }
}

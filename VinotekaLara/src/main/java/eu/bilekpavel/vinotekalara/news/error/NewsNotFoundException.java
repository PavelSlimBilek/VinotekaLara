package eu.bilekpavel.vinotekalara.news.error;

import lombok.Getter;

@Getter
public class NewsNotFoundException extends NewsException {

    // TODO we may want this for localized Exceptions - just don't forget
    private final String id;

    public NewsNotFoundException(String id) {
        super("News id:'" + id + "' not found");
        this.id = id;
    }
}

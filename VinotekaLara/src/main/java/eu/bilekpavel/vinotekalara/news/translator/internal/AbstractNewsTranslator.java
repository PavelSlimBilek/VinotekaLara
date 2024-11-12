package eu.bilekpavel.vinotekalara.news.translator.internal;

import eu.bilekpavel.vinotekalara.news.translator.NewsTranslator;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class AbstractNewsTranslator implements NewsTranslator {
    private final String NEWS;
    private final String PUBLISH;
    private final String HIDE;

    @Override
    public String news() {
        return NEWS;
    }

    @Override
    public String publish() {
        return PUBLISH;
    }

    @Override
    public String hide() {
        return HIDE;
    }
}

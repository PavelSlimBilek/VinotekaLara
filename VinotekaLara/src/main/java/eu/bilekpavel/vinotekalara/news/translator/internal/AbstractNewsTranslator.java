package eu.bilekpavel.vinotekalara.news.translator.internal;

import eu.bilekpavel.vinotekalara.news.translator.NewsTranslator;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class AbstractNewsTranslator implements NewsTranslator {
    private final String NEWS;

    @Override
    public String news() {
        return NEWS;
    }
}

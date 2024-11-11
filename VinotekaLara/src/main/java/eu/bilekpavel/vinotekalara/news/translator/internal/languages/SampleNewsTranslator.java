package eu.bilekpavel.vinotekalara.news.translator.internal.languages;

import eu.bilekpavel.vinotekalara.news.translator.internal.AbstractNewsTranslator;
import org.springframework.stereotype.Component;

@Component
public class SampleNewsTranslator extends AbstractNewsTranslator {
    public SampleNewsTranslator() {
        super(
                "NEWS"
        );
    }
}

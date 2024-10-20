package eu.bilekpavel.vinotekalara.homepage.translator.languages;

import eu.bilekpavel.vinotekalara.homepage.translator.AbstractHomePageData;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("ukrainianPageTranslator")
public final class UkrainianHomePageData extends AbstractHomePageData {
    public UkrainianHomePageData() {
        super(
                "Винний магазин Лара",
                "Ласкаво просимо!",
                "Винний магазин у живописному містечку регіону Височина."
        );
    }
}

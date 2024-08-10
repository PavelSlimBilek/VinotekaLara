package eu.bilekpavel.vinotekalara.homepage.translator.languages;

import eu.bilekpavel.vinotekalara.homepage.translator.AbstractHomePageData;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("englishPageTranslator")
public final class EnglishHomePageData extends AbstractHomePageData {

    public EnglishHomePageData() {
        super("Wine shop lara",
                "Welcome!",
                "Wine shop in a picturesque town in the Vysočina region."
        );
    }
}
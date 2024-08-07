package eu.bilekpavel.vinotekalara.front.translator.language;

import eu.bilekpavel.vinotekalara.front.translator.AbstractHomePageTranslator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("englishPageTranslator")
public final class EnglishHomePageTranslator extends AbstractHomePageTranslator {

    public EnglishHomePageTranslator() {
        super("Wine shop lara",
                "Welcome!",
                "Wine shop in a picturesque town in the Vysočina region."
        );
    }
}
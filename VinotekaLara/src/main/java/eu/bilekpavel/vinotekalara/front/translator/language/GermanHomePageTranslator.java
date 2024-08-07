package eu.bilekpavel.vinotekalara.front.translator.language;

import eu.bilekpavel.vinotekalara.front.translator.AbstractHomePageTranslator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("germanPageTranslator")
public final class GermanHomePageTranslator extends AbstractHomePageTranslator {

    public GermanHomePageTranslator() {
        super("Weinladen Lara",
                "Wilkommen!",
                "Weinladen in einer malerischen Stadt in der Region Vysočina."
        );
    }
}
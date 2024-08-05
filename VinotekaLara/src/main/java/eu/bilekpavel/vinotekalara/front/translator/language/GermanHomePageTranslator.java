package eu.bilekpavel.vinotekalara.front.translator.language;

import eu.bilekpavel.vinotekalara.front.translator.AbstractHomePageTranslator;
import eu.bilekpavel.vinotekalara.translator.dto.Language;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("german")
public final class GermanHomePageTranslator extends AbstractHomePageTranslator {

    public GermanHomePageTranslator() {
        super(Language.GERMAN,
                "Weinladen Lara",
                "Wilkommen!",
                "Weinladen in einer malerischen Stadt in der Region Vysočina."
        );
    }
}
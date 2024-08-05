package eu.bilekpavel.vinotekalara.front.translator.language;

import eu.bilekpavel.vinotekalara.front.translator.AbstractHomePageTranslator;
import eu.bilekpavel.vinotekalara.translator.dto.Language;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("english")
public final class EnglishHomePageTranslator extends AbstractHomePageTranslator {

    public EnglishHomePageTranslator() {
        super(Language.ENGLISH,
                "'Lara' wine shop",
                "Welcome!",
                "Wine shop in a picturesque town in the Vysočina region."
        );
    }
}
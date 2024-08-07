package eu.bilekpavel.vinotekalara.front.translator.language;

import eu.bilekpavel.vinotekalara.front.translator.AbstractHomePageTranslator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("czechPageTranslator")
public final class CzechHomePageTranslator extends AbstractHomePageTranslator {

    public CzechHomePageTranslator() {
        super("Vinotéka Lara",
                "Vítejte!",
                "Vinotéka v malebném městečku na Vysočině."
        );
    }
}
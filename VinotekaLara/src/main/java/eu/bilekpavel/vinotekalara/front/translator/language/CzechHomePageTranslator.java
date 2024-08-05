package eu.bilekpavel.vinotekalara.front.translator.language;

import eu.bilekpavel.vinotekalara.front.translator.AbstractHomePageTranslator;
import eu.bilekpavel.vinotekalara.translator.Language;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("czech")
public final class CzechHomePageTranslator extends AbstractHomePageTranslator {

    public CzechHomePageTranslator() {
        super(Language.CZECH,
                "Vinotéka Lara",
                "Vítejte!",
                "Vinotéka v malebném městečku na Vysočině."
        );
    }
}

package eu.bilekpavel.vinotekalara.homepage.translator.languages;

import eu.bilekpavel.vinotekalara.homepage.translator.AbstractHomePageData;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("czechPageTranslator")
public final class CzechHomePageData extends AbstractHomePageData {

    public CzechHomePageData() {
        super("Vinotéka Lara",
                "Vítejte!",
                "Vinotéka v malebném městečku na Vysočině."
        );
    }
}
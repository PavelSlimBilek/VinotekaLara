package eu.bilekpavel.vinotekalara.view.translator.languages;

import eu.bilekpavel.vinotekalara.view.translator.AbstractHomePageData;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("germanPageTranslator")
public final class GermanHomePageData extends AbstractHomePageData {

    public GermanHomePageData() {
        super("Weinladen Lara",
                "Wilkommen!",
                "Weinladen in einer malerischen Stadt in der Region Vysočina."
        );
    }
}
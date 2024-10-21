package eu.bilekpavel.vinotekalara.homepage.translator.languages;

import eu.bilekpavel.vinotekalara.homepage.translator.AbstractHomePageData;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("frenchPageTranslator")
public class FrenchHomePageData extends AbstractHomePageData {
    public FrenchHomePageData() {
        super("Cave à vin Lara",
                "Bienvenue !",
                "Cave à vin dans une ville pittoresque de la région de Vysočina."
        );
    }
}

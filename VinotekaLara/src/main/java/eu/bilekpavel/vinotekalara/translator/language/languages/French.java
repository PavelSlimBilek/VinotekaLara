package eu.bilekpavel.vinotekalara.translator.language.languages;

import eu.bilekpavel.vinotekalara.alertbar.translator.AlertBarTranslator;
import eu.bilekpavel.vinotekalara.app.translator.CoreTranslator;
import eu.bilekpavel.vinotekalara.homepage.translator.HomePageTranslatorInterface;
import eu.bilekpavel.vinotekalara.openinghours.translator.OpeningHoursTranslator;
import eu.bilekpavel.vinotekalara.superadmin.translator.AdminTranslatorInterface;
import eu.bilekpavel.vinotekalara.translator.dto.Flag;
import eu.bilekpavel.vinotekalara.translator.impl.Locale;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class French extends Locale {
    public French(
            @Qualifier("frenchHoursTranslator") OpeningHoursTranslator hoursTranslator,
            @Qualifier("frenchPageTranslator") HomePageTranslatorInterface pageTranslator,
            @Qualifier("frenchAdmin") AdminTranslatorInterface adminTranslator,
            AlertBarTranslator alertBarTranslator,
            CoreTranslator coreTranslator
    ) {
        super(
                Language.FRENCH,
                new Flag("/images/flags/france.png", "français"),
                coreTranslator,
                hoursTranslator,
                pageTranslator,
                adminTranslator,
                alertBarTranslator
        );
    }
}

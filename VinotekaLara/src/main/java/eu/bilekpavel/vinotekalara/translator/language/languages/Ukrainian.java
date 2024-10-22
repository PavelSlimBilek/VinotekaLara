package eu.bilekpavel.vinotekalara.translator.language.languages;

import eu.bilekpavel.vinotekalara.alertbar.translator.AlertBarTranslator;
import eu.bilekpavel.vinotekalara.app.core.translator.CoreTranslator;
import eu.bilekpavel.vinotekalara.homepage.translator.HomePageTranslatorInterface;
import eu.bilekpavel.vinotekalara.openinghours.translator.OpeningHoursTranslator;
import eu.bilekpavel.vinotekalara.superadmin.translator.AdminTranslatorInterface;
import eu.bilekpavel.vinotekalara.translator.dto.Flag;
import eu.bilekpavel.vinotekalara.translator.impl.Locale;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Ukrainian extends Locale {
    public Ukrainian(
            @Qualifier("ukrainianHoursTranslator") OpeningHoursTranslator hoursTranslator,
            @Qualifier("ukrainianPageTranslator") HomePageTranslatorInterface pageTranslator,
            @Qualifier("ukrainianAdmin") AdminTranslatorInterface adminTranslator,
            AlertBarTranslator alertBarTranslator,
            CoreTranslator coreTranslator
    ) {
        super(
                Language.UKRAINIAN,
                new Flag("/images/flags/ukraine.png", "український"),
                coreTranslator,
                hoursTranslator,
                pageTranslator,
                adminTranslator,
                alertBarTranslator
        );
    }
}

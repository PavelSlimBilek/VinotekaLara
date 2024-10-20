package eu.bilekpavel.vinotekalara.translator.language.languages;

import eu.bilekpavel.vinotekalara.homepage.translator.HomePageTranslatorInterface;
import eu.bilekpavel.vinotekalara.openinghours.translator.OpeningHoursTranslatorInterface;
import eu.bilekpavel.vinotekalara.superadmin.translator.AdminTranslatorInterface;
import eu.bilekpavel.vinotekalara.translator.dto.Flag;
import eu.bilekpavel.vinotekalara.translator.impl.Locale;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Ukrainian extends Locale {
    public Ukrainian(
            @Qualifier("ukrainianHoursTranslator") OpeningHoursTranslatorInterface hoursTranslator,
            @Qualifier("ukrainianPageTranslator") HomePageTranslatorInterface pageTranslator,
            @Qualifier("ukrainianAdmin") AdminTranslatorInterface adminTranslator
    ) {
        super(
                Language.UKRAINIAN,
                new Flag("/images/flags/ukraine.png", "український"),
                hoursTranslator,
                pageTranslator,
                adminTranslator
        );
    }
}

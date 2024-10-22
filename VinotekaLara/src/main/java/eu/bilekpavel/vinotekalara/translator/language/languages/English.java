package eu.bilekpavel.vinotekalara.translator.language.languages;

import eu.bilekpavel.vinotekalara.alertbar.translator.AlertBarTranslator;
import eu.bilekpavel.vinotekalara.homepage.translator.HomePageTranslatorInterface;
import eu.bilekpavel.vinotekalara.openinghours.translator.OpeningHoursTranslator;
import eu.bilekpavel.vinotekalara.superadmin.translator.AdminTranslatorInterface;
import eu.bilekpavel.vinotekalara.translator.dto.Flag;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import eu.bilekpavel.vinotekalara.translator.impl.Locale;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("englishLocale")
public class English extends Locale {

    public English(@Qualifier("englishHoursTranslator") OpeningHoursTranslator hoursTranslator,
                   @Qualifier("englishPageTranslator") HomePageTranslatorInterface pageTranslator,
                   @Qualifier("englishAdmin") AdminTranslatorInterface adminTranslator,
                   AlertBarTranslator alertBarTranslator
    ) {
        super(
                Language.ENGLISH,
                new Flag("/images/flags/uk.png", "english"),
                hoursTranslator,
                pageTranslator,
                adminTranslator,
                alertBarTranslator
        );
    }
}
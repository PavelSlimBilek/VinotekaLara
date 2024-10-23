package eu.bilekpavel.vinotekalara.translator.language.languages;

import eu.bilekpavel.vinotekalara.alertbar.translator.AlertBarTranslator;
import eu.bilekpavel.vinotekalara.app.translator.CoreTranslator;
import eu.bilekpavel.vinotekalara.homepage.translator.HomePageTranslator;
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
                   HomePageTranslator pageTranslator,
                   @Qualifier("englishAdmin") AdminTranslatorInterface adminTranslator,
                   AlertBarTranslator alertBarTranslator,
                   CoreTranslator coreTranslator
    ) {
        super(
                Language.ENGLISH,
                new Flag("/images/flags/uk.png", "english"),
                coreTranslator,
                hoursTranslator,
                pageTranslator,
                adminTranslator,
                alertBarTranslator
        );
    }
}
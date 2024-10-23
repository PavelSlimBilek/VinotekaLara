package eu.bilekpavel.vinotekalara.translator.language.languages;

import eu.bilekpavel.vinotekalara.alertbar.translator.AlertBarTranslator;
import eu.bilekpavel.vinotekalara.app.translator.CoreTranslator;
import eu.bilekpavel.vinotekalara.homepage.translator.HomePageTranslatorInterface;
import eu.bilekpavel.vinotekalara.openinghours.translator.OpeningHoursTranslator;
import eu.bilekpavel.vinotekalara.superadmin.translator.AdminTranslatorInterface;
import eu.bilekpavel.vinotekalara.translator.dto.Flag;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import eu.bilekpavel.vinotekalara.translator.impl.Locale;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("germanLocale")
public class German extends Locale {
    public German(@Qualifier("germanHoursTranslator") OpeningHoursTranslator hoursTranslator,
                  @Qualifier("germanPageTranslator") HomePageTranslatorInterface pageTranslator,
                  @Qualifier("germanAdmin")AdminTranslatorInterface adminTranslator,
                  AlertBarTranslator alertBarTranslator,
                  CoreTranslator coreTranslator
    ) {
        super(
                Language.GERMAN,
                new Flag("/images/flags/germany.png", "deutsch"),
                coreTranslator,
                hoursTranslator,
                pageTranslator,
                adminTranslator,
                alertBarTranslator
        );
    }
}
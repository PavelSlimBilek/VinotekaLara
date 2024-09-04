package eu.bilekpavel.vinotekalara.translator.language.languages;

import eu.bilekpavel.vinotekalara.homepage.translator.HomePageTranslatorInterface;
import eu.bilekpavel.vinotekalara.openinghours.translator.OpeningHoursTranslatorInterface;
import eu.bilekpavel.vinotekalara.translator.dto.Flag;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import eu.bilekpavel.vinotekalara.translator.impl.Locale;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("germanLocale")
public class German extends Locale {
    public German(@Qualifier("germanHoursTranslator") OpeningHoursTranslatorInterface hoursTranslator,
                  @Qualifier("germanPageTranslator") HomePageTranslatorInterface pageTranslator) {
        super(Language.GERMAN,
                new Flag("/images/flags/germany.png", "deutsch"),
                hoursTranslator,
                pageTranslator
        );
    }
}
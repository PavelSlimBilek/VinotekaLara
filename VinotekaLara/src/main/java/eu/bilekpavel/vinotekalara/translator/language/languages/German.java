package eu.bilekpavel.vinotekalara.translator.language.languages;

import eu.bilekpavel.vinotekalara.view.translator.HomePageTranslatorInterface;
import eu.bilekpavel.vinotekalara.openinghours.translator.OpeningHoursTranslatorInterface;
import eu.bilekpavel.vinotekalara.translator.dto.Flag;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import eu.bilekpavel.vinotekalara.translator.Locale;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("germanLocale")
public class German extends Locale {
    public German(@Qualifier("germanHoursTranslator") OpeningHoursTranslatorInterface hoursTranslator,
                  @Qualifier("germanPageTranslator") HomePageTranslatorInterface pageTranslator) {
        super(Language.GERMAN,
                "de",
                new Flag("/images/translator/flags/flag_germany.png", "deutsch"),
                hoursTranslator,
                pageTranslator
        );
    }
}
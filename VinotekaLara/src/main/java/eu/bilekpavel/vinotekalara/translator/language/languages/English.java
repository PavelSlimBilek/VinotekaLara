package eu.bilekpavel.vinotekalara.translator.language.languages;

import eu.bilekpavel.vinotekalara.homepage.translator.HomePageTranslatorInterface;
import eu.bilekpavel.vinotekalara.openinghours.translator.OpeningHoursTranslatorInterface;
import eu.bilekpavel.vinotekalara.translator.dto.Flag;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import eu.bilekpavel.vinotekalara.translator.impl.Locale;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("englishLocale")
public class English extends Locale {

    public English(@Qualifier("englishHoursTranslator") OpeningHoursTranslatorInterface hoursTranslator,
                   @Qualifier("englishPageTranslator")HomePageTranslatorInterface pageTranslator) {
        super(Language.ENGLISH,
                new Flag("/images/flags/uk.png", "english"),
                hoursTranslator,
                pageTranslator
        );
    }
}
package eu.bilekpavel.vinotekalara.translator.language.languages;

import eu.bilekpavel.vinotekalara.view.translator.HomePageTranslatorInterface;
import eu.bilekpavel.vinotekalara.openinghours.translator.OpeningHoursTranslatorInterface;
import eu.bilekpavel.vinotekalara.translator.dto.Flag;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import eu.bilekpavel.vinotekalara.translator.Locale;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("czechLocale")
public class Czech extends Locale {
    public Czech(@Qualifier("czechHoursTranslator") OpeningHoursTranslatorInterface hoursTranslator,
                 @Qualifier("czechPageTranslator") HomePageTranslatorInterface pageTranslator) {
        super(Language.CZECH,
                "cs",
                new Flag("/images/translator/flags/flag_czech.png", "česky"),
                hoursTranslator,
                pageTranslator);
    }
}
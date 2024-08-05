package eu.bilekpavel.vinotekalara.openinghours.translator.languages;

import eu.bilekpavel.vinotekalara.openinghours.translator.AbstractOpeningHoursTranslator;
import eu.bilekpavel.vinotekalara.translator.Language;
import org.springframework.stereotype.Component;

@Component("czech")
public class CzechOpeningHoursTranslator extends AbstractOpeningHoursTranslator {

    public CzechOpeningHoursTranslator() {
        super(Language.CZECH,
                "Otevírací hodiny",
                "Otevřeno",
                "Zavřeno",
                "Pondělí",
                "Úterý",
                "Středa",
                "Čtvrtek",
                "Pátek",
                "Sobota",
                "Neděle",
                "zavřeno",
                "začátek",
                "konec",
                "den",
                "ranní směna",
                "odpolední směna"
        );
    }
}
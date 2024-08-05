package eu.bilekpavel.vinotekalara.openinghours.translator.languages;

import eu.bilekpavel.vinotekalara.openinghours.translator.AbstractOpeningHoursTranslator;
import org.springframework.stereotype.Component;

@Component("czechTransformer")
public class CzechOpeningHoursTranslator extends AbstractOpeningHoursTranslator {

    public CzechOpeningHoursTranslator() {
        super("Otevírací hodiny",
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
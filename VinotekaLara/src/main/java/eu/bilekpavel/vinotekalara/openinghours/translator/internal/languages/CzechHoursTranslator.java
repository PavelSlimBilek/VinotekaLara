package eu.bilekpavel.vinotekalara.openinghours.translator.internal.languages;

import eu.bilekpavel.vinotekalara.openinghours.WeeklyHoursConfig;
import eu.bilekpavel.vinotekalara.openinghours.translator.internal.AbstractOpeningHoursTranslator;
import org.springframework.stereotype.Component;

@Component("czechHoursTranslator")
public class CzechHoursTranslator extends AbstractOpeningHoursTranslator {
    public CzechHoursTranslator(WeeklyHoursConfig config) {
        super(
                "Otevírací hodiny",
                "Právě je otevřeno",
                "Je bohužel zavřeno",
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
                "ráno",
                "odpoledne",
                config
        );
    }
}
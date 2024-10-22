package eu.bilekpavel.vinotekalara.openinghours.translator.internal.languages;

import eu.bilekpavel.vinotekalara.openinghours.config.WeeklyHoursConfig;
import eu.bilekpavel.vinotekalara.openinghours.translator.internal.AbstractOpeningHoursTranslator;
import org.springframework.stereotype.Component;

@Component("czechHoursTranslator")
public class CzechHoursTranslator extends AbstractOpeningHoursTranslator {
    public CzechHoursTranslator(WeeklyHoursConfig config) {
        super(
                "otevírací hodiny",
                "právě je otevřeno",
                "je bohužel zavřeno",
                "pondělí",
                "úterý",
                "středa",
                "čtvrtek",
                "pátek",
                "sobota",
                "neděle",
                "zavřeno",
                "začátek",
                "konec",
                "den",
                "ráno",
                "odpoledne",
                "",
                "",
                "",
                config
        );
    }
}
package eu.bilekpavel.vinotekalara.translator;

import org.springframework.stereotype.Component;

@Component("czechTransformer")
public class CzechTranslator extends AbstractTranslator {

    public CzechTranslator() {
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
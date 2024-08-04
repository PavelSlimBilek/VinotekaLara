package eu.bilekpavel.vinotekalara.util;

import org.springframework.stereotype.Component;

@Component
public class CzechOpeningHoursTransformer extends OpeningHoursAbstractTransformer {

    public CzechOpeningHoursTransformer() {
        super("Otevřeno",
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
                "odpoledne"
        );
    }
}
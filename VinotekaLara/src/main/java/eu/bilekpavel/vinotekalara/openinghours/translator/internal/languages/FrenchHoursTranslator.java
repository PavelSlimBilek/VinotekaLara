package eu.bilekpavel.vinotekalara.openinghours.translator.internal.languages;

import eu.bilekpavel.vinotekalara.openinghours.WeeklyHoursConfig;
import eu.bilekpavel.vinotekalara.openinghours.translator.internal.AbstractOpeningHoursTranslator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("frenchHoursTranslator")
public class FrenchHoursTranslator extends AbstractOpeningHoursTranslator {
    public FrenchHoursTranslator(WeeklyHoursConfig CONFIG) {
        super("Horaires d'ouverture",
                "C'est ouvert maintenant",
                "C'est fermé maintenant",
                "Lundi",
                "Mardi",
                "Mercredi",
                "Jeudi",
                "Vendredi",
                "Samedi",
                "Dimanche",
                "fermé",
                "début",
                "fin",
                "jour",
                "heures du matin",
                "heures de l'après-midi",
                CONFIG
        );    }
}

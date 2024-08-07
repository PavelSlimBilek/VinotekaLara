package eu.bilekpavel.vinotekalara.translator.module.openinghours;

import eu.bilekpavel.vinotekalara.openinghours.translator.AbstractOpeningHoursTranslator;
import org.springframework.stereotype.Component;

@Component("germanHoursTranslator")
public class GermanOpeningHoursTranslator extends AbstractOpeningHoursTranslator {

    public GermanOpeningHoursTranslator() {
        super("Öffnungszeiten",
                "Jetzt geöffnet",
                "Jetzt geschlossen",
                "Montag",
                "Dienstag",
                "Mittwoch",
                "Donnerstag",
                "Freitag",
                "Samstag",
                "Sonntag",
                "geschlossen",
                "Anfang",
                "Ende",
                "Tag",
                "Morgenschicht",
                "Nachmittagsschicht"
        );
    }
}

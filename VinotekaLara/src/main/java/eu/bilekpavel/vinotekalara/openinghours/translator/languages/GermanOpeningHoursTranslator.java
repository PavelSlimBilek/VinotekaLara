package eu.bilekpavel.vinotekalara.openinghours.translator.languages;

import eu.bilekpavel.vinotekalara.openinghours.translator.AbstractOpeningHoursTranslator;
import eu.bilekpavel.vinotekalara.translator.dto.Language;
import org.springframework.stereotype.Component;

@Component("german")
public class GermanOpeningHoursTranslator extends AbstractOpeningHoursTranslator {

    public GermanOpeningHoursTranslator() {
        super(Language.GERMAN,
                "Öffnungszeiten",
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

package eu.bilekpavel.vinotekalara.openinghours.translator.internal.languages;

import eu.bilekpavel.vinotekalara.openinghours.config.WeeklyHoursConfig;
import eu.bilekpavel.vinotekalara.openinghours.translator.internal.AbstractOpeningHoursTranslator;
import org.springframework.stereotype.Component;

@Component("germanHoursTranslator")
public class GermanHoursTranslator extends AbstractOpeningHoursTranslator {
    public GermanHoursTranslator(WeeklyHoursConfig config) {
        super(
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
                "Beginn",
                "Ende",
                "Tag",
                "Vormittag",
                "Nachmittag",
                "",
                "",
                "",
                config
        );
    }
}
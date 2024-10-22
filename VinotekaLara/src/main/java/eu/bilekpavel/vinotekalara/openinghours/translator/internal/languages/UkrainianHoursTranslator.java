package eu.bilekpavel.vinotekalara.openinghours.translator.internal.languages;

import eu.bilekpavel.vinotekalara.openinghours.config.WeeklyHoursConfig;
import eu.bilekpavel.vinotekalara.openinghours.translator.internal.AbstractOpeningHoursTranslator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("ukrainianHoursTranslator")
public class UkrainianHoursTranslator extends AbstractOpeningHoursTranslator {
    public UkrainianHoursTranslator(
            WeeklyHoursConfig CONFIG
    ) {
        super("Години роботи",              // Opening hours
                "Зараз відкрито",           // It's opened now
                "Зараз закрито",            // It's closed now
                "Понеділок",                // Monday
                "Вівторок",                 // Tuesday
                "Середа",                   // Wednesday
                "Четвер",                   // Thursday
                "П'ятниця",                 // Friday
                "Субота",                   // Saturday
                "Неділя",                   // Sunday
                "закрито",                  // closed
                "початок",                  // start
                "кінець",                   // end
                "день",                     // day
                "ранкові години",           // morning hours
                "допівденні години",        // afternoon hours
                "",
                "",
                "",
                CONFIG
        );
    }
}

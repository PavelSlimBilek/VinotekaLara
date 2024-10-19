package eu.bilekpavel.vinotekalara.openinghours.translator.languages;


import eu.bilekpavel.vinotekalara.openinghours.WeeklyHoursConfig;
import eu.bilekpavel.vinotekalara.openinghours.translator.AbstractOpeningHoursTranslator;
import org.springframework.stereotype.Component;

@Component("englishHoursTranslator")
public class EnglishHoursTranslator extends AbstractOpeningHoursTranslator {

    public EnglishHoursTranslator(WeeklyHoursConfig config) {
        super("Opening hours",
                "It's opened now",
                "It's closed now",
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday",
                "closed",
                "start",
                "end",
                "day",
                "morning hours",
                "afternoon hours",
                config
        );
    }
}
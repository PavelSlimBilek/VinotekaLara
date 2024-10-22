package eu.bilekpavel.vinotekalara.openinghours.translator.internal.languages;


import eu.bilekpavel.vinotekalara.openinghours.config.WeeklyHoursConfig;
import eu.bilekpavel.vinotekalara.openinghours.translator.internal.AbstractOpeningHoursTranslator;
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
                "select opening hours",
                "current opening hours",
                "set opening hours",
                config
        );
    }
}
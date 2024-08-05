package eu.bilekpavel.vinotekalara.openinghours.translator.languages;

import eu.bilekpavel.vinotekalara.openinghours.translator.AbstractOpeningHoursTranslator;
import eu.bilekpavel.vinotekalara.translator.dto.Language;
import org.springframework.stereotype.Component;

@Component("english")
public class EnglishOpeningHoursTranslator extends AbstractOpeningHoursTranslator {

    public EnglishOpeningHoursTranslator() {
        super(Language.ENGLISH,
                "Opening hours",
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
                "afternoon hours"
        );
    }
}

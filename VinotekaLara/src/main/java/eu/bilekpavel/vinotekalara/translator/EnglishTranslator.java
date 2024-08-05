package eu.bilekpavel.vinotekalara.translator;

import org.springframework.stereotype.Component;

@Component("englishTransformer")
public class EnglishTranslator extends AbstractTranslator {

    public EnglishTranslator() {
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
                "afternoon hours"
        );
    }
}

package eu.bilekpavel.vinotekalara.openinghours.translator.internal.languages;

import eu.bilekpavel.vinotekalara.openinghours.config.WeeklyHoursConfig;
import eu.bilekpavel.vinotekalara.openinghours.translator.internal.AbstractOpeningHoursTranslator;
import org.springframework.stereotype.Component;

@Component
public final class SampleHoursTranslator extends AbstractOpeningHoursTranslator {

    public SampleHoursTranslator(WeeklyHoursConfig config) {
        super(
                "OPENING_HOURS",
                "OPENED_MESSAGE",
                "CLOSED_MESSAGE",
                "DAY",
                "MONDAY",
                "TUESDAY",
                "WEDNESDAY",
                "THURSDAY",
                "FRIDAY",
                "SATURDAY",
                "SUNDAY",
                "CLOSED",
                "START",
                "END",
                "MORNING_HOURS",
                "AFTERNOON_HOURS",
                "SELECT_HOURS",
                "ACTIVE_HOURS",
                "SET_HOURS",
                config // TODO try to decouple this BS!
        );
    }
}
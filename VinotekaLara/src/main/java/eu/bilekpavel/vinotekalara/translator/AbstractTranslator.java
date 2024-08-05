package eu.bilekpavel.vinotekalara.translator;

import eu.bilekpavel.vinotekalara.config.AppSettings;
import eu.bilekpavel.vinotekalara.openinghours.dto.OpeningHours;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public abstract class AbstractTranslator implements TranslatorInterface {

    private final String OPENING_HOURS;

    private final String OPENED_MESSAGE;
    private final String CLOSED_MESSAGE;

    private final String MONDAY;
    private final String TUESDAY;
    private final String WEDNESDAY;
    private final String THURSDAY;
    private final String FRIDAY;
    private final String SATURDAY;
    private final String SUNDAY;
    private final String CLOSED;

    private final String START;
    private final String END;
    private final String DAY;
    private final String MORNING_HOURS;
    private final String AFTERNOON_HOURS;

    @Override
    public final String transform(OpeningHours hours) {
        if (hours == null) {
            return null;
        }
        String transformedDay = switch(hours.getDay()) {
            case MONDAY -> this.getMONDAY();
            case TUESDAY -> this.getTUESDAY();
            case WEDNESDAY -> this.getWEDNESDAY();
            case THURSDAY -> this.getTHURSDAY();
            case FRIDAY -> this.getFRIDAY();
            case SATURDAY -> this.getSATURDAY();
            case SUNDAY -> this.getSUNDAY();
        };

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s: %s - %s",
                transformedDay,
                hours.getMorningHours().start().toString().substring(0, 5),
                hours.getMorningHours().end().toString().substring(0, 5)
        ));

        if (AppSettings.areAfternoonHoursAllowed) {
            sb.append(hours.getAfternoonHours() == null
                    ? "  |  " + CLOSED
                    : String.format("  |  %s - %s",
                    hours.getAfternoonHours().start(),
                    hours.getAfternoonHours().end()
            ));
        }

        return sb.toString();
    }

    @Override
    public final List<String> transformAll(List<OpeningHours> hours) {
        return hours.stream().map(this::transform).toList();
    }

    @Override
    public final String isOpenedMessage(boolean isOpened) {
        return isOpened ? OPENED_MESSAGE : CLOSED_MESSAGE;
    }
}
package eu.bilekpavel.vinotekalara.openinghours.translator.internal;

import eu.bilekpavel.vinotekalara.openinghours.config.WeeklyHoursConfig;
import eu.bilekpavel.vinotekalara.openinghours.dto.DailyHours;
import eu.bilekpavel.vinotekalara.openinghours.translator.OpeningHoursTranslator;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class AbstractOpeningHoursTranslator implements OpeningHoursTranslator {
    private final String OPENING_HOURS;

    private final String OPENED_MESSAGE;
    private final String CLOSED_MESSAGE;

    private final String DAY;
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

    private final String MORNING_HOURS;
    private final String AFTERNOON_HOURS;

    private final String SELECT_HOURS;
    private final String ACTIVE_HOURS;
    private final String SET_HOURS;

    private WeeklyHoursConfig CONFIG;

    @Override
    public final String transform(DailyHours hours) {
        if (hours == null) {
            return null;
        }

        String translatedDay = switch(hours.dayOfWeek()) {
            case null -> this.SUNDAY;
            case MONDAY -> this.MONDAY;
            case TUESDAY -> this.TUESDAY;
            case WEDNESDAY -> this.WEDNESDAY;
            case THURSDAY -> this.THURSDAY;
            case FRIDAY -> this.FRIDAY;
            case SATURDAY -> this.SATURDAY;
            case SUNDAY -> this.SUNDAY;
        };

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s: %s - %s",
                translatedDay,
                hours.morningHours() == null ? CLOSED : hours.morningHours().start().toString().substring(0, 5),
                hours.morningHours() == null ? CLOSED : hours.morningHours().end().toString().substring(0, 5)
        ));

        if (CONFIG.areAfternoonHoursAllowed()) {
            sb.append("  |  ");
            sb.append(hours.afternoonHours() == null
                    ? CLOSED
                    : String.format("%s - %s", hours.afternoonHours().start(), hours.afternoonHours().end()
            ));
        }

        return sb.toString();
    }

    @Override
    public final List<String> transformAll(List<DailyHours> hours) {
        return hours.stream().map(this::transform).toList();
    }

    @Override
    public String isOpenedMessage(boolean isOpened) {
        return isOpened ? OPENED_MESSAGE : CLOSED_MESSAGE; // TODO this logic should be moved!!
    }

    @Override
    public String day() {
        return DAY;
    }

    @Override
    public String monday() {
        return MONDAY;
    }

    @Override
    public String tuesday() {
        return TUESDAY;
    }

    @Override
    public String wednesday() {
        return WEDNESDAY;
    }

    @Override
    public String thursday() {
        return THURSDAY;
    }

    @Override
    public String friday() {
        return FRIDAY;
    }

    @Override
    public String saturday() {
        return SATURDAY;
    }

    @Override
    public String sunday() {
        return SUNDAY;
    }

    @Override
    public String start() {
        return START;
    }

    @Override
    public String end() {
        return END;
    }

    @Override
    public String morningHours() {
        return MORNING_HOURS;
    }

    @Override
    public String afternoonHours() {
        return AFTERNOON_HOURS;
    }

    @Override
    public String openingHours() {
        return OPENING_HOURS;
    }

    @Override
    public String selectHours() {
        return SELECT_HOURS;
    }

    @Override
    public String activeHours() {
        return ACTIVE_HOURS;
    }

    @Override
    public String setHours() {
        return SET_HOURS;
    }
}
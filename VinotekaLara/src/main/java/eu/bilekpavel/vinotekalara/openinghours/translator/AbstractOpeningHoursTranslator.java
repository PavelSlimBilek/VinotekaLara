package eu.bilekpavel.vinotekalara.openinghours.translator;

import eu.bilekpavel.vinotekalara.app.AppSettings;
import eu.bilekpavel.vinotekalara.openinghours.WeeklyHoursConfig;
import eu.bilekpavel.vinotekalara.openinghours.dto.DailyHours;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public abstract class AbstractOpeningHoursTranslator implements OpeningHoursTranslatorInterface {

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
    public final String getIsOpenedMessage(boolean isOpened) {
        return isOpened ? OPENED_MESSAGE : CLOSED_MESSAGE;
    }

    @Override
    public final String getMonday() {
        return MONDAY;
    }

    @Override
    public final String getTuesday() {
        return TUESDAY;
    }

    @Override
    public final String getWednesday() {
        return WEDNESDAY;
    }

    @Override
    public final String getThursday() {
        return THURSDAY;
    }

    @Override
    public final String getFriday() {
        return FRIDAY;
    }

    @Override
    public final String getSaturday() {
        return SATURDAY;
    }

    @Override
    public final String getSunday() {
        return SUNDAY;
    }

    @Override
    public final String getDay() {
        return DAY;
    }

    @Override
    public final String getStart() {
        return START;
    }

    @Override
    public final String getEnd(){
        return END;
    }

    @Override
    public final String getMorningHours() {
        return MORNING_HOURS;
    }

    @Override
    public final String getAfternoonHours() {
        return AFTERNOON_HOURS;
    }

    @Override
    public final String getOpeningHours() {
        return OPENING_HOURS;
    }
}
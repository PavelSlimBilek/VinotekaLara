package eu.bilekpavel.vinotekalara.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Time;
import java.text.ParseException;
import java.time.DayOfWeek;

@Getter
@AllArgsConstructor
public class OpeningHours {
    private final DayOfWeek day;
    private final TimeInterval morningHours;
    private final TimeInterval afternoonHours;

    public OpeningHours(OpeningHoursRequest request) throws ParseException {
        try {
            this.day = DayOfWeek.valueOf(request.day());

            Time morningStart = Time.valueOf(request.morningStart() + ":00");
            Time morningEnd =  Time.valueOf(request.morningEnd() + ":00");
            if (morningEnd.before(morningStart)) {
                throw new ParseException("Start time is after end time", 0);
            }
            this.morningHours = new TimeInterval(morningStart, morningEnd);

            if (request.afternoonStart().isBlank() || request.afternoonEnd().isBlank() ||
                request.afternoonStart().isEmpty() || request.afternoonEnd().isEmpty()){
                this.afternoonHours = null;
            } else {
                Time afternoonStart = Time.valueOf(request.afternoonStart() + ":00");
                Time afternoonEnd = Time.valueOf(request.afternoonEnd() + ":00");
                if (afternoonEnd.before(afternoonStart) || afternoonStart.before(morningEnd)) {
                    throw new ParseException("Start time is after end time", 0);
                }
                this.afternoonHours = new TimeInterval(afternoonStart, afternoonEnd);
            }

        } catch (Exception e) {
            throw new ParseException(e.getMessage(), 0);
        }
    }

    public String toCzech() {
        String czechDay;
        switch (this.day) {
            case MONDAY ->  czechDay = "Pondělí";
            case TUESDAY -> czechDay = "Úterý";
            case WEDNESDAY -> czechDay = "Středa";
            case THURSDAY -> czechDay = "Čtvrtek";
            case FRIDAY -> czechDay = "Pátek";
            case SATURDAY -> czechDay = "Sobota";
            case SUNDAY -> czechDay = "Neděle";
            default -> czechDay = "";
        }

        if (this.afternoonHours == null) {
            return String.format("%s : %s - %s | zavřeno",
                    czechDay,
                    String.format("%s", this.getMorningHours().start().toString().substring(0, 5)),
                    String.format("%s", this.getMorningHours().end().toString().substring(0, 5))
            );
        }
        return String.format("%s : %s - %s  |  %s - %s",
                czechDay,
                String.format("%s", this.getMorningHours().start().toString().substring(0, 5)),
                String.format("%s", this.getMorningHours().end().toString().substring(0, 5)),
                String.format("%s", this.getAfternoonHours().start().toString().substring(0, 5)),
                String.format("%s", this.getAfternoonHours().end().toString().substring(0, 5))
        );
    }

    @Override
    public String toString() {
        if (this.afternoonHours == null) {
            return String.format("%d,%s,%s,%s",
                    this.day.getValue(),
                    this.day.name(),
                    this.morningHours.start(),
                    this.morningHours.end()
            );
        }
        return String.format("%d,%s,%s,%s,%s,%s",
                this.day.getValue(),
                this.day.name(),
                this.morningHours.start(),
                this.morningHours.end(),
                this.afternoonHours.start(),
                this.afternoonHours.end()
        );
    }
}
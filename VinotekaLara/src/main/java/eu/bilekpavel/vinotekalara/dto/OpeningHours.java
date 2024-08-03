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
    private final TimeInterval hours;

    public OpeningHours(OpeningHoursRequest request) throws ParseException {
        try {
            DayOfWeek day = DayOfWeek.valueOf(request.day());
            Time start = Time.valueOf(request.start() + ":00");
            Time end =  Time.valueOf(request.end() + ":00");
            if (end.before(start)) {
                throw new ParseException("Start time is after end time", 0);
            }
            this.day = day;
            this.hours = new TimeInterval(start, end);
        } catch (Exception e) {
            throw new ParseException(e.getMessage(), 0);
        }
    }

    public String toCzech() {
        String czechDay = "";
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
        return String.format("%s - %s : %s",
                czechDay,
                String.format("%s", this.getHours().start().toString().substring(0, 5)),
                String.format("%s", this.getHours().end().toString().substring(0, 5))
        );
    }
}
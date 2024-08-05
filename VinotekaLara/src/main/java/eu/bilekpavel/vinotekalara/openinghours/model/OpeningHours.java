package eu.bilekpavel.vinotekalara.openinghours.model;

import eu.bilekpavel.vinotekalara.openinghours.dto.OpeningHoursRequest;
import eu.bilekpavel.vinotekalara.openinghours.dto.TimeInterval;
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
            this.day = DayOfWeek.of(Integer.parseInt(request.dayValue()));

            Time morningStart = Time.valueOf(request.morningStart() + ":00");
            Time morningEnd =  Time.valueOf(request.morningEnd() + ":00");
            if (morningEnd.before(morningStart)) {
                throw new ParseException("Start time is after _end time", 0);
            }
            this.morningHours = new TimeInterval(morningStart, morningEnd);

            if (request.afternoonStart() == null || request.afternoonEnd() == null ||
                request.afternoonStart().isBlank() || request.afternoonEnd().isBlank()){
                this.afternoonHours = null;
            } else {
                Time afternoonStart = Time.valueOf(request.afternoonStart() + ":00");
                Time afternoonEnd = Time.valueOf(request.afternoonEnd() + ":00");
                if (afternoonEnd.before(afternoonStart) || afternoonStart.before(morningEnd)) {
                    throw new ParseException("Start time is after _end time", 0);
                }
                this.afternoonHours = new TimeInterval(afternoonStart, afternoonEnd);
            }

        } catch (Exception e) {
            throw new ParseException(e.getMessage(), 0);
        }
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
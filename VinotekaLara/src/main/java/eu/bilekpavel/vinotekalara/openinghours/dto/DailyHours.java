package eu.bilekpavel.vinotekalara.openinghours.dto;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

import java.time.DayOfWeek;

@Embeddable
public record DailyHours (
    DayOfWeek dayOfWeek,
    @Embedded
    TimeInterval morningHours,
    @Embedded
    TimeInterval afternoonHours
) {
    public DailyHours(DayOfWeek dayOfWeek, TimeInterval morningHours, TimeInterval afternoonHours) {
        this.dayOfWeek = dayOfWeek;
        this.morningHours = morningHours;
        this.afternoonHours = afternoonHours;
    }
}

package eu.bilekpavel.vinotekalara.openinghours.model;

import eu.bilekpavel.vinotekalara.openinghours.dto.DailyHours;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.DayOfWeek;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public final class WeeklyHours {

    @Id
    @GeneratedValue
    private int id;

    @Setter
    private String userIdentifier;

    @Setter
    private boolean isRemoved;

    @Setter
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "dayOfWeek", column = @Column(name = "monday_day_of_week", updatable = false)),

            @AttributeOverride(name = "morningHours.start", column = @Column(name = "monday_morning_start")),
            @AttributeOverride(name = "morningHours.end", column = @Column(name = "monday_morning_end")),
            @AttributeOverride(name = "afternoonHours.start", column = @Column(name = "monday_afternoon_start")),
            @AttributeOverride(name = "afternoonHours.end", column = @Column(name = "monday_afternoon_end"))
    })
    private DailyHours monday;

    @Setter
    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "dayOfWeek", column = @Column(name = "tuesday_day_of_week", updatable = false)),

            @AttributeOverride(name = "morningHours.start", column = @Column(name = "tuesday_morning_start")),
            @AttributeOverride(name = "morningHours.end", column = @Column(name = "tuesday_morning_end")),
            @AttributeOverride(name = "afternoonHours.start", column = @Column(name = "tuesday_afternoon_start")),
            @AttributeOverride(name = "afternoonHours.end", column = @Column(name = "tuesday_afternoon_end"))
    })
    private DailyHours tuesday;

    @Setter
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "dayOfWeek", column = @Column(name = "wednesday_day_of_week", updatable = false)),

            @AttributeOverride(name = "morningHours.start", column = @Column(name = "wednesday_morning_start")),
            @AttributeOverride(name = "morningHours.end", column = @Column(name = "wednesday_morning_end")),
            @AttributeOverride(name = "afternoonHours.start", column = @Column(name = "wednesday_afternoon_start")),
            @AttributeOverride(name = "afternoonHours.end", column = @Column(name = "wednesday_afternoon_end"))
    })
    private DailyHours wednesday;

    @Setter
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "dayOfWeek", column = @Column(name = "thursday_day_of_week", updatable = false)),

            @AttributeOverride(name = "morningHours.start", column = @Column(name = "thursday_morning_start")),
            @AttributeOverride(name = "morningHours.end", column = @Column(name = "thursday_morning_end")),
            @AttributeOverride(name = "afternoonHours.start", column = @Column(name = "thursday_afternoon_start")),
            @AttributeOverride(name = "afternoonHours.end", column = @Column(name = "thursday_afternoon_end"))
    })
    private DailyHours thursday;

    @Setter
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "dayOfWeek", column = @Column(name = "friday_day_of_week", updatable = false)),

            @AttributeOverride(name = "morningHours.start", column = @Column(name = "friday_morning_start")),
            @AttributeOverride(name = "morningHours.end", column = @Column(name = "friday_morning_end")),
            @AttributeOverride(name = "afternoonHours.start", column = @Column(name = "friday_afternoon_start")),
            @AttributeOverride(name = "afternoonHours.end", column = @Column(name = "friday_afternoon_end"))
    })
    private DailyHours friday;

    @Setter
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "dayOfWeek", column = @Column(name = "saturday_day_of_week", updatable = false)),

            @AttributeOverride(name = "morningHours.start", column = @Column(name = "saturday_morning_start")),
            @AttributeOverride(name = "morningHours.end", column = @Column(name = "saturday_morning_end")),
            @AttributeOverride(name = "afternoonHours.start", column = @Column(name = "saturday_afternoon_start")),
            @AttributeOverride(name = "afternoonHours.end", column = @Column(name = "saturday_afternoon_end"))
    })
    private DailyHours saturday;

    @Setter
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "dayOfWeek", column = @Column(name = "sunday_day_of_week", updatable = false)),

            @AttributeOverride(name = "morningHours.start", column = @Column(name = "sunday_morning_start")),
            @AttributeOverride(name = "morningHours.end", column = @Column(name = "sunday_morning_end")),
            @AttributeOverride(name = "afternoonHours.start", column = @Column(name = "sunday_afternoon_start")),
            @AttributeOverride(name = "afternoonHours.end", column = @Column(name = "sunday_afternoon_end"))
    })
    private DailyHours sunday;

    public WeeklyHours(String userIdentifier) {
        this.userIdentifier = userIdentifier;
        monday = new DailyHours(DayOfWeek.MONDAY, null, null);
        tuesday = new DailyHours(DayOfWeek.TUESDAY, null, null);
        wednesday = new DailyHours(DayOfWeek.WEDNESDAY, null, null);
        thursday = new DailyHours(DayOfWeek.THURSDAY, null, null);
        friday = new DailyHours(DayOfWeek.FRIDAY, null, null);
        saturday = new DailyHours(DayOfWeek.SATURDAY, null, null);
        sunday = new DailyHours(DayOfWeek.SUNDAY, null, null);
    }
    
    public List<DailyHours> getHours() {
        return List.of(monday, tuesday, wednesday, thursday, friday, saturday, sunday);
    }

    public DailyHours getHours(DayOfWeek dayOfWeek) {
        return switch (dayOfWeek) {
            case MONDAY -> monday;
            case TUESDAY -> tuesday;
            case WEDNESDAY -> wednesday;
            case THURSDAY -> thursday;
            case FRIDAY -> friday;
            case SATURDAY -> saturday;
            case SUNDAY -> sunday;
        };
    }

    public void setDailyHours(DailyHours dailyHours) {
        switch (dailyHours.dayOfWeek()) {
            case MONDAY -> monday = dailyHours;
            case TUESDAY -> tuesday = dailyHours;
            case WEDNESDAY -> wednesday = dailyHours;
            case THURSDAY -> thursday = dailyHours;
            case FRIDAY -> friday = dailyHours;
            case SATURDAY -> saturday = dailyHours;
            case SUNDAY -> sunday = dailyHours;
        }
    }
}

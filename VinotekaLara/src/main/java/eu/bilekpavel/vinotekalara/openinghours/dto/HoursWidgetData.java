package eu.bilekpavel.vinotekalara.openinghours.dto;

import java.util.List;

public record HoursWidgetData(
        List<WeeklyHoursData> weeklyHours,
        WeeklyHoursData activeHours
) {
}

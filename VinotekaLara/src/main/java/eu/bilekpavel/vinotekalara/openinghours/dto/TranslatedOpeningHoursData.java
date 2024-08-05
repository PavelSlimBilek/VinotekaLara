package eu.bilekpavel.vinotekalara.openinghours.dto;

import eu.bilekpavel.vinotekalara.openinghours.translator.dto.TranslatedDayOfWeek;

import java.util.List;

public record TranslatedOpeningHoursData(
    String dayWord,
    String startWord,
    String endWord,
    String morningHours,
    String afternoonHours,
    String openingHours,
    List<TranslatedDayOfWeek> daysOfWeek,
    List<String> openingHoursList,
    String todayHours,
    String isOpenedMessage
) {
}
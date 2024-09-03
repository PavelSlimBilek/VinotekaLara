package eu.bilekpavel.vinotekalara.openinghours.dto;

import eu.bilekpavel.vinotekalara.openinghours.translator.dto.LocalizedDayOfWeek;

import java.util.List;

public record LocalizedOpeningHours(
    String dayWord,
    String startWord,
    String endWord,
    String morningHours,
    String afternoonHours,
    String openingHours,
    List<LocalizedDayOfWeek> daysOfWeek,
    List<String> openingHoursList,
    String todayHours,
    String isOpenedMessage
) {
}
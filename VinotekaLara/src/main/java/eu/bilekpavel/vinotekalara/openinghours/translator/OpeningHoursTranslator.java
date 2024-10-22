package eu.bilekpavel.vinotekalara.openinghours.translator;

import eu.bilekpavel.vinotekalara.openinghours.dto.DailyHours;

import java.util.List;

public interface OpeningHoursTranslator {
    String transform(DailyHours hours);
    List<String> transformAll(List<DailyHours> hours);
    String isOpenedMessage(boolean isOpened);

    String day();
    String monday();
    String tuesday();
    String wednesday();
    String thursday();
    String friday();
    String saturday();
    String sunday();

    String start();
    String end();
    String morningHours();
    String afternoonHours();

    String openingHours();
    String selectHours();
    String activeHours();
    String setHours();
}
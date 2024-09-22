package eu.bilekpavel.vinotekalara.openinghours.translator;

import eu.bilekpavel.vinotekalara.openinghours.dto.DailyHours;

import java.util.List;

public interface OpeningHoursTranslatorInterface {
    String transform(DailyHours hours);
    List<String> transformAll(List<DailyHours> hours);
    String getIsOpenedMessage(boolean isOpened);

    String getDay();
    String getMonday();
    String getTuesday();
    String getWednesday();
    String getThursday();
    String getFriday();
    String getSaturday();

    String getSunday();

    String getOpeningHours();
    String getStart();
    String getEnd();
    String getMorningHours();
    String getAfternoonHours();

}
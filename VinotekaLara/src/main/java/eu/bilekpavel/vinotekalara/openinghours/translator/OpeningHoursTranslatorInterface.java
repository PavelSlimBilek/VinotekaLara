package eu.bilekpavel.vinotekalara.openinghours.translator;

import eu.bilekpavel.vinotekalara.openinghours.model.OpeningHours;

import java.util.List;

public interface OpeningHoursTranslatorInterface {
    String transform(OpeningHours hours);
    List<String> transformAll(List<OpeningHours> hours);
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
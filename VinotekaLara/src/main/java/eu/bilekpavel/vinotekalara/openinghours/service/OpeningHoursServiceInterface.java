package eu.bilekpavel.vinotekalara.openinghours.service;

import eu.bilekpavel.vinotekalara.openinghours.dto.LocalizedOpeningHours;
import eu.bilekpavel.vinotekalara.openinghours.model.OpeningHours;
import eu.bilekpavel.vinotekalara.openinghours.dto.OpeningHoursRequest;
import eu.bilekpavel.vinotekalara.openinghours.translator.OpeningHoursTranslatorInterface;
import eu.bilekpavel.vinotekalara.openinghours.translator.dto.LocalizedDayOfWeek;

import java.util.List;

public interface OpeningHoursServiceInterface {
    void save(OpeningHoursRequest hours) throws Exception;
    List<OpeningHours> getCachedOpeningHours();
    boolean isOpened();
    void updateHours();
    OpeningHours getTodayHours();

    List<String> getTranslatedOpeningHours(OpeningHoursTranslatorInterface transformer);
    String getTranslatedTodayHours(OpeningHoursTranslatorInterface transformer);
    String getTranslatedOpenedMessage(OpeningHoursTranslatorInterface transformer);
    List<LocalizedDayOfWeek> getTranslatedDaysOfWeek(OpeningHoursTranslatorInterface translator);

    LocalizedOpeningHours getTranslatedData(OpeningHoursTranslatorInterface hoursTranslator);
}
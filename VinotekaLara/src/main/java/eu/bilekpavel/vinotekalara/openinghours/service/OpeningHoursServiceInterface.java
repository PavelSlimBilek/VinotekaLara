package eu.bilekpavel.vinotekalara.openinghours.service;

import eu.bilekpavel.vinotekalara.openinghours.dto.OpeningHours;
import eu.bilekpavel.vinotekalara.openinghours.dto.OpeningHoursRequest;
import eu.bilekpavel.vinotekalara.translator.TranslatorInterface;

import java.util.List;

public interface OpeningHoursServiceInterface {
    void save(OpeningHoursRequest hours) throws Exception;
    List<OpeningHours> getCachedOpeningHours();
    boolean isOpened();
    void updateHours();
    OpeningHours getTodayHours();

    List<String> getTransformedOpeningHours(TranslatorInterface transformer);
    String getTransformedTodayHours(TranslatorInterface transformer);
    String getOpenedMessage(TranslatorInterface transformer);
}
package eu.bilekpavel.vinotekalara.service;

import eu.bilekpavel.vinotekalara.dto.OpeningHours;
import eu.bilekpavel.vinotekalara.dto.OpeningHoursRequest;

import java.util.List;

public interface OpeningHoursServiceInterface {
    void save(OpeningHoursRequest hours) throws Exception;
    List<OpeningHours> getOpeningHours();
    boolean isOpened();
    void updateHours();
    OpeningHours getTodayHours();
}
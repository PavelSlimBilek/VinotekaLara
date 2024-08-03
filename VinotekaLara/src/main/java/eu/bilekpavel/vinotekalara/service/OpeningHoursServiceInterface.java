package eu.bilekpavel.vinotekalara.service;

import eu.bilekpavel.vinotekalara.dto.OpeningHours;
import eu.bilekpavel.vinotekalara.dto.OpeningHoursRequest;

import java.util.List;

public interface OpeningHoursServiceInterface {
    boolean save(OpeningHoursRequest hours);
    List<OpeningHours> getOpeningHours();
    boolean isOpened();
    void updateHours();
    OpeningHours getTodayHours();
}
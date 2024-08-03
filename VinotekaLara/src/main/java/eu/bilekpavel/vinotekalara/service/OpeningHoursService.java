package eu.bilekpavel.vinotekalara.service;

import eu.bilekpavel.vinotekalara.dto.OpeningHours;
import org.springframework.stereotype.Service;

@Service
public class OpeningHoursService implements OpeningHourServiceInterface {

    @Override
    public boolean save(OpeningHours hours) {
        return true;
    }
}
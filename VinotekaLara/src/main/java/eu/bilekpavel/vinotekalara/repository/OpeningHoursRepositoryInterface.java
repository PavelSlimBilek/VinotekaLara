package eu.bilekpavel.vinotekalara.repository;

import eu.bilekpavel.vinotekalara.dto.OpeningHours;

import java.io.IOException;
import java.util.List;

public interface OpeningHoursRepositoryInterface {
    void save(OpeningHours openingHours) throws IOException;
    List<OpeningHours> getAll();
}
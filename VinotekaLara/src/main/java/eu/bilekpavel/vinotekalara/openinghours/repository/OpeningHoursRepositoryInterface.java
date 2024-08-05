package eu.bilekpavel.vinotekalara.openinghours.repository;

import eu.bilekpavel.vinotekalara.openinghours.model.OpeningHours;

import java.io.IOException;
import java.util.List;

public interface OpeningHoursRepositoryInterface {
    void save(OpeningHours openingHours) throws IOException;
    List<OpeningHours> getAll();
}
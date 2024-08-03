package eu.bilekpavel.vinotekalara.repository;

import eu.bilekpavel.vinotekalara.dto.OpeningHours;

import java.util.List;

public interface OpeningHoursRepositoryInterface {
    boolean save(OpeningHours openingHours);
    List<OpeningHours> getAll();
}
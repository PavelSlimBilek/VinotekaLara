package eu.bilekpavel.vinotekalara.openinghours.repository;

import eu.bilekpavel.vinotekalara.openinghours.model.WeeklyHours;

import java.util.List;
import java.util.Optional;

public interface WeeklyHoursRepositoryInterface {
    List<WeeklyHours> findAll();
    WeeklyHours save(WeeklyHours hours);
    Optional<WeeklyHours> findById(int id);

    Optional<WeeklyHours> findFirstBy();
}

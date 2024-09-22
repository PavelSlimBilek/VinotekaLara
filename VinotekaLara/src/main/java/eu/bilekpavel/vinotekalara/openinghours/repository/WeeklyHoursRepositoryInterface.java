package eu.bilekpavel.vinotekalara.openinghours.repository;

import eu.bilekpavel.vinotekalara.openinghours.model.WeeklyHours;

import java.util.List;

public interface WeeklyHoursRepositoryInterface {
    List<WeeklyHours> findAll();
    WeeklyHours save(WeeklyHours hours);
    WeeklyHours find(int id);
}

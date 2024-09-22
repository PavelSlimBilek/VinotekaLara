package eu.bilekpavel.vinotekalara.openinghours.repository;

import eu.bilekpavel.vinotekalara.openinghours.model.WeeklyHours;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class WeeklyHoursInMemoryRepository implements WeeklyHoursRepositoryInterface{

    private final List<WeeklyHours> hours;

    public WeeklyHoursInMemoryRepository() {
        hours = new ArrayList<>();
    }

    @Override
    public List<WeeklyHours> findAll() {
        return hours;
    }

    @Override
    public WeeklyHours save(WeeklyHours weeklyHours) {
        hours.add(weeklyHours);
        return weeklyHours;
    }

    @Override
    public WeeklyHours find(int id) {
        return hours.stream()
                .filter(hours -> hours.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
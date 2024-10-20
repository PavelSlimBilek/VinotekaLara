package eu.bilekpavel.vinotekalara.openinghours.repository;

import eu.bilekpavel.vinotekalara.openinghours.model.WeeklyHours;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@Qualifier("hours_in_memory_repository")
public class WeeklyHoursInMemoryRepository implements WeeklyHoursRepositoryInterface{

    private final Map<Integer, WeeklyHours> HOURS;

    public WeeklyHoursInMemoryRepository() {
        HOURS = new HashMap<>();
    }

    @Override
    public List<WeeklyHours> findAll() {
        return HOURS.values().stream().toList();
    }

    @Override
    public WeeklyHours save(WeeklyHours weeklyHours) {
        HOURS.put(weeklyHours.getId(), weeklyHours);
        return weeklyHours;
    }

    @Override
    public Optional<WeeklyHours> findById(int id) {
        return Optional.ofNullable(HOURS.get(id));
    }

    @Override
    public Optional<WeeklyHours> findFirstBy() {
        return HOURS.values().stream().findFirst();
    }
}

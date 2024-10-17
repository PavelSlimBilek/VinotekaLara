package eu.bilekpavel.vinotekalara.openinghours.repository;

import eu.bilekpavel.vinotekalara.openinghours.model.WeeklyHours;
import jakarta.annotation.Nonnull;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("hours_db_repository")
public interface WeeklyHoursRepository extends JpaRepository<WeeklyHours, Integer>, WeeklyHoursRepositoryInterface {
    @Override
    WeeklyHours save(@Nonnull WeeklyHours hours);
    @Override
    WeeklyHours findById(int id);
    @Override
    List<WeeklyHours> findAll();
}

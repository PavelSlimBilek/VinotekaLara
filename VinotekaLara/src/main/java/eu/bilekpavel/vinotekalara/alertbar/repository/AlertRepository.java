package eu.bilekpavel.vinotekalara.alertbar.repository;

import eu.bilekpavel.vinotekalara.alertbar.model.Alert;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Qualifier("alert_db_repository")
public interface AlertRepository extends AlertRepositoryInterface, JpaRepository<Alert, Integer> {

    @Override
    Optional<Alert> findById(int id);

    @Override
    List<Alert> findAll();

    @Override
    Alert save(Alert alert);

    @Override
    Optional<Alert> findByActive(boolean isActive);
}

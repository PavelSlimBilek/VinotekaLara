package eu.bilekpavel.vinotekalara.alertbar.repository;

import eu.bilekpavel.vinotekalara.alertbar.domain.Alert;

import java.util.List;
import java.util.Optional;

public interface AlertRepositoryInterface {
    Optional<Alert> findById(int id);
    List<Alert> findAll();
    Alert save(Alert alert);
}
package eu.bilekpavel.vinotekalara.alertbar.domain;

import java.util.List;
import java.util.Optional;

public interface AlertRepositoryInterface {
    Optional<Alert> get(int id);
    List<Alert> getAll();
    void save(Alert alert);
}
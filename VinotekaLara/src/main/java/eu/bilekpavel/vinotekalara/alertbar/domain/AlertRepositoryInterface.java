package eu.bilekpavel.vinotekalara.alertbar.domain;

import java.util.List;

public interface AlertRepositoryInterface {
    Alert get(int id);
    List<Alert> getAll();
    void save(Alert alert);
}
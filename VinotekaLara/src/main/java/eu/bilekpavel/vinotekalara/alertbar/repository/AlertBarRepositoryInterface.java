package eu.bilekpavel.vinotekalara.alertbar.repository;

import eu.bilekpavel.vinotekalara.alertbar.model.Alert;

import java.util.List;

public interface AlertBarRepositoryInterface {
    Alert get(int id);
    List<Alert> getAll();
    void save(Alert alert);
}
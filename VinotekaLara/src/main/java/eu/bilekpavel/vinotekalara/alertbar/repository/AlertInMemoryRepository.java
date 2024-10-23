package eu.bilekpavel.vinotekalara.alertbar.repository;

import eu.bilekpavel.vinotekalara.alertbar.model.Alert;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@Qualifier("alert_map_repository")
public final class AlertInMemoryRepository implements AlertRepositoryInterface {

    private final Map<Integer, Alert> ALERTS;

    public AlertInMemoryRepository() {
        ALERTS = new ConcurrentHashMap<>();
    }

    @Override
    public Optional<Alert> findById(int id) {
        return Optional.ofNullable(ALERTS.get(id));
    }

    @Override
    public List<Alert> findAll() {
        return ALERTS.values().stream().toList();
    }

    @Override
    public Alert save(Alert alert) {
        try {
            ALERTS.put(alert.getId(), alert);
        } catch (Exception e) {
            return null;
        }
        return alert;
    }

    @Override
    public Optional<Alert> findByActive(boolean isActive) {
        return ALERTS.values().stream()
                .filter(a -> a.isActive() == isActive)
                .findFirst();
    }
}
package eu.bilekpavel.vinotekalara.alertbar.repository;

import eu.bilekpavel.vinotekalara.alertbar.error.AlertValidationError;
import eu.bilekpavel.vinotekalara.alertbar.model.Alert;
import eu.bilekpavel.vinotekalara.alertbar.model.AlertBuilder;
import eu.bilekpavel.vinotekalara.translator.dto.LocalizedString;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AlertInMemoryRepository implements AlertBarRepositoryInterface {

    private final Map<Integer, Alert> ALERTS;
    private final int TEMP_ID = 1;

    public AlertInMemoryRepository() throws AlertValidationError {
        Alert alert = new AlertBuilder()
                .addLocalization(
                        new LocalizedString(Language.CZECH, "payload")
                ).addLocalization(
                        new LocalizedString(Language.ENGLISH, "payload EN")
                ).addLocalization(
                        new LocalizedString(Language.GERMAN, "payload DE")

                ).build();

        ALERTS = new HashMap<>();
        ALERTS.put(TEMP_ID, alert);
    }

    @Override
    public Alert get(int id) {
        return ALERTS.get(id);
    }

    @Override
    public List<Alert> getAll() {
        return ALERTS.values().stream().toList();
    }

    @Override
    public void save(Alert alert) {
        ALERTS.put(TEMP_ID, alert);
    }
}
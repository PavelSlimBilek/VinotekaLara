package eu.bilekpavel.vinotekalara.alertbar.repository;

import eu.bilekpavel.vinotekalara.alertbar.dto.AlertRequest;
import eu.bilekpavel.vinotekalara.alertbar.error.AlertValidationError;
import eu.bilekpavel.vinotekalara.alertbar.model.Alert;
import eu.bilekpavel.vinotekalara.translator.domain.LocalizedString;
import eu.bilekpavel.vinotekalara.translator.dto.LocalizedStringRequest;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AlertInMemoryRepository implements AlertRepositoryInterface {

    private final Map<String, Alert> ALERTS;

    public AlertInMemoryRepository() throws AlertValidationError {
        ALERTS = new HashMap<>();
            ALERTS.put(
                    "1",
                    new Alert(
                            new AlertRequest(
                                    new LocalizedString(
                                            new LocalizedStringRequest(
                                                    "Máme nový web!",
                                                    Language.CZECH
                                            )
                                    ),
                                    List.of(
                                            new LocalizedString(
                                                    new LocalizedStringRequest(
                                                            "We have a new web page!",
                                                            Language.ENGLISH
                                                    )),
                                            new LocalizedString(
                                                    new LocalizedStringRequest(
                                                            "Wir haben eine newe Website!",
                                                            Language.GERMAN
                                                    )
                                            )
                                    ),
                                    "#ffffff"
                            )
                    )
            );
    }

    @Override
    public List<Alert> getAll() {
        return ALERTS.values().stream().toList();
    }

    @Override
    public void update(Alert alert) {
        ALERTS.put("1", alert);
    }
}
package eu.bilekpavel.vinotekalara.alertbar.repository;

import eu.bilekpavel.vinotekalara.alertbar.dto.AlertRequest;
import eu.bilekpavel.vinotekalara.alertbar.model.Alert;
import eu.bilekpavel.vinotekalara.translator.dto.LocalizedString;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AlertInMemoryRepository implements AlertBarRepositoryInterface {

    private final List<Alert> alertList;

    public AlertInMemoryRepository() {
        alertList = new ArrayList<>();
        alertList.add(
                new Alert(
                        new AlertRequest(
                                new LocalizedString(
                                        Language.CZECH,
                                        "Máme nový web"
                                ),
                                "420"
                )
        ));
    }

    @Override
    public List<Alert> getAll() {
        return alertList;
    }
}
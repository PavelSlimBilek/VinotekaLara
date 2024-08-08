package eu.bilekpavel.vinotekalara.alertbar.repository;

import eu.bilekpavel.vinotekalara.alertbar.dto.AlertRequest;
import eu.bilekpavel.vinotekalara.alertbar.model.Alert;
import eu.bilekpavel.vinotekalara.translator.dto.LocalizedString;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AlertInMemoryRepository implements AlertRepositoryInterface {

    private final List<Alert> alertList;

    public AlertInMemoryRepository() {
        alertList = new ArrayList<>();
        alertList.add(
                new Alert(
                        new AlertRequest(
                                new LocalizedString(
                                        Language.CZECH,
                                        "Máme nový web!"
                                ),
                                List.of(
                                        new LocalizedString(Language.ENGLISH, "We have a new web page!"),
                                        new LocalizedString(Language.GERMAN, "Wir haben eine neue Website!")
                                ),
                                "whitesmoke"
                )
        ));
    }

    @Override
    public List<Alert> getAll() {
        return alertList;
    }
}
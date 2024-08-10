package eu.bilekpavel.vinotekalara.alertbar.repository;

import eu.bilekpavel.vinotekalara.alertbar.dto.AlertRequest;
import eu.bilekpavel.vinotekalara.alertbar.error.AlertValidationError;
import eu.bilekpavel.vinotekalara.alertbar.model.Alert;
import eu.bilekpavel.vinotekalara.translator.domain.LocalizedString;
import eu.bilekpavel.vinotekalara.translator.dto.LocalizedStringRequest;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AlertInMemoryRepository implements AlertRepositoryInterface {

    private final List<Alert> alertList;

    public AlertInMemoryRepository() throws AlertValidationError {
        alertList = new ArrayList<>();
            alertList.add(
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
        return alertList;
    }
}
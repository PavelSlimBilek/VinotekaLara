package eu.bilekpavel.vinotekalara.alertbar.repository;

import eu.bilekpavel.vinotekalara.alertbar.model.Alert;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AlertInMemoryRepository implements AlertBarRepositoryInterface {

    private final List<Alert> alertList;

    public AlertInMemoryRepository() {
        alertList = new ArrayList<>();
        alertList.add(new Alert(
                "Máme nové webové stránky!",
                "We have a new web page!",
                "Wir haben eine neue Webseite!",
                "limegreen"
        ));
    }

    @Override
    public List<Alert> getAll() {
        return alertList;
    }
}
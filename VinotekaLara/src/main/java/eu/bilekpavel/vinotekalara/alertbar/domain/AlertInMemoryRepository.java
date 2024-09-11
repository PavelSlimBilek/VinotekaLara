package eu.bilekpavel.vinotekalara.alertbar.domain;

import eu.bilekpavel.vinotekalara.translator.dto.LocalizedString;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AlertInMemoryRepository implements AlertRepositoryInterface {

    private final Map<Integer, Alert> ALERTS;

    public AlertInMemoryRepository() {
        Alert alert1 = new AlertBuilder()
                .addLocalization(
                        new LocalizedString(Language.CZECH, "Máme nový web!")
                ).addLocalization(
                        new LocalizedString(Language.ENGLISH, "We have a new website!")
                ).addLocalization(
                        new LocalizedString(Language.GERMAN, "Wir haben wine neue Website!")

                ).build();

        Alert alert2 = new AlertBuilder()
                .addLocalization(
                        new LocalizedString(Language.CZECH, "Vytvořeno Liborem Skunkem!")
                ).addLocalization(
                        new LocalizedString(Language.ENGLISH, "Made by Libor Skunk!")
                ).addLocalization(
                        new LocalizedString(Language.GERMAN, "Hergestellt von Libor Skunk!")
                ).build();

        ALERTS = new HashMap<>();
        ALERTS.put(alert1.getId(), alert1);
        ALERTS.put(alert2.getId(), alert2);
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
        ALERTS.put(alert.getId(), alert);
    }
}
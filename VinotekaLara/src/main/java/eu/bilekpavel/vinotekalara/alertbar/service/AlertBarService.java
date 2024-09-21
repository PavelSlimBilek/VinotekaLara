package eu.bilekpavel.vinotekalara.alertbar.service;

import eu.bilekpavel.vinotekalara.alertbar.dto.AlertRequest;
import eu.bilekpavel.vinotekalara.app.Color;
import eu.bilekpavel.vinotekalara.alertbar.domain.Alert;
import eu.bilekpavel.vinotekalara.alertbar.domain.AlertBuilder;
import eu.bilekpavel.vinotekalara.alertbar.domain.AlertRepositoryInterface;
import eu.bilekpavel.vinotekalara.alertbar.dto.LocalizedAlert;
import eu.bilekpavel.vinotekalara.translator.dto.LocalizedString;
import eu.bilekpavel.vinotekalara.translator.dto.LocalizedStringRequest;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import eu.bilekpavel.vinotekalara.translator.api.LocalizedStringFactoryInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AlertBarService implements AlertServiceInterface {

    private final AlertRepositoryInterface repo;
    private final LocalizedStringFactoryInterface localizedStringFactory;

    private static int activeAlertId = 1;

    @Override
    public void create(AlertRequest request) {
        // we use AlertBuilder
        AlertBuilder builder = new AlertBuilder();
        for (LocalizedStringRequest localization : request.translations()) {
            builder.addLocalization(
                    localizedStringFactory.create(localization)
            );
        }
        repo.save(builder.build());
    }

    @Override
    public LocalizedAlert getLocalized(int id, Language language) {
        Optional<Alert> optAlert = repo.get(id);

        if (optAlert.isEmpty()) {
            return new LocalizedAlert(
                    0,
                    localizedStringFactory.create("err", "Something went wrong"),
                    "tomato"
            );
        }

        Alert alert = optAlert.get();
        return alert.getLocalized(language) == null
                ? new LocalizedAlert(
                        alert.getId(),
                        localizedStringFactory.create(language.getCode(), alert.getLocalized(language)),
                        alert.getBackgroundColor())
                : new LocalizedAlert(
                        alert.getId(),
                        localizedStringFactory.create(language.getCode(), alert.getLocalized(Language.CZECH)),
                        alert.getBackgroundColor());
    }

    @Override
    public List<LocalizedAlert> getAllLocalized(Language language) {
        return repo.getAll().stream()
                .map((ab) -> new LocalizedAlert(
                        ab.getId(),
                        localizedStringFactory.create(language.getCode(), ab.getLocalized(language)),
                        ab.getBackgroundColor())
                ).toList();
    }

    @Override
    public void updateColor(int id, Color color) {
        Optional<Alert> optAlert = repo.get(id);
        if (optAlert.isEmpty()) {
            return;
        }

        optAlert.get().setBackgroundColor(color.toRgbString());
        repo.save(optAlert.get());
    }

    @Override
    public void updateLocalization(int id, LocalizedStringRequest request) {
        Optional<Alert> optAlert = repo.get(id);
        if (optAlert.isEmpty()) {
            return;
        }

        LocalizedString content = localizedStringFactory.create(request);
        optAlert.get().updateLocalization(content);
    }

    @Override
    public Optional<Alert> get(int id) {
        return repo.get(id);
    }

    @Override
    public void setActive(int id) {
        activeAlertId = id;
    }

    @Override
    public LocalizedAlert getActive(Language language) {
        Optional<Alert> active = repo.get(activeAlertId);
        if (active.isEmpty()) {
            return new LocalizedAlert(
                    0,
                    localizedStringFactory.create("err", "Something went wrong"),
                    "tomato"
            );
        }

        return new LocalizedAlert(
                active.get().getId(),
                localizedStringFactory.create(language.getCode(), active.get().getLocalized(language)),
                active.get().getBackgroundColor()
        );
    }
}
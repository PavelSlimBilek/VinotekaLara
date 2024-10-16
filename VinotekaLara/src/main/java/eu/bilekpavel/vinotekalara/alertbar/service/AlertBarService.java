package eu.bilekpavel.vinotekalara.alertbar.service;

import eu.bilekpavel.vinotekalara.alertbar.dto.AlertRequest;
import eu.bilekpavel.vinotekalara.app.Color;
import eu.bilekpavel.vinotekalara.alertbar.domain.Alert;
import eu.bilekpavel.vinotekalara.alertbar.domain.AlertBuilder;
import eu.bilekpavel.vinotekalara.alertbar.domain.AlertRepositoryInterface;
import eu.bilekpavel.vinotekalara.alertbar.dto.LocalizedAlert;
import eu.bilekpavel.vinotekalara.superadmin.AlertBarConfig;
import eu.bilekpavel.vinotekalara.translator.dto.LocalizedString;
import eu.bilekpavel.vinotekalara.translator.dto.LocalizedStringRequest;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import eu.bilekpavel.vinotekalara.translator.api.LocalizedStringFactoryInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AlertBarService implements AlertServiceInterface {

    private final AlertRepositoryInterface repo;
    private final LocalizedStringFactoryInterface localizedStringFactory;

    private final AlertBarConfig config;

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
        Alert alert = repo.get(id);
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
        Alert alert = repo.get(id);
        alert.setBackgroundColor(color.toRgbString());
        repo.save(alert);
    }

    @Override
    public void updateLocalization(int id, LocalizedStringRequest request) {
        Alert alert = repo.get(id);
        LocalizedString content = localizedStringFactory.create(request);
        alert.updateLocalization(content);
    }

    @Override
    public Alert get(int id) {
        return repo.get(id);
    }

    @Override
    public void setActive(int id) {
        activeAlertId = id;
    }

    @Override
    public LocalizedAlert getActive(Language language) {
        Alert active = repo.get(activeAlertId);
        return new LocalizedAlert(
                active.getId(),
                localizedStringFactory.create(language.getCode(), active.getLocalized(language)),
                active.getBackgroundColor()
        );
    }

    @Override
    public void allow(boolean isAllowed) {
        System.out.println("invoked");
        config.allow(isAllowed);
    }

    @Override
    public void display(boolean isDisplayed) {
        config.display(isDisplayed);
    }

    @Override
    public void toggle() {
        config.display(!config.isDisplayed());
    }

    @Override
    public boolean isAllowed() {
        return config.isAllowed();
    }

    @Override
    public boolean isDisplayed() {
        return config.isDisplayed();
    }
}
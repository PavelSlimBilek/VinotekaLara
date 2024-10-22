package eu.bilekpavel.vinotekalara.alertbar.service;

import eu.bilekpavel.vinotekalara.alertbar.dto.AlertBarWidgetData;
import eu.bilekpavel.vinotekalara.alertbar.dto.AlertFullData;
import eu.bilekpavel.vinotekalara.alertbar.dto.AlertRequest;
import eu.bilekpavel.vinotekalara.app.dto.Color;
import eu.bilekpavel.vinotekalara.alertbar.domain.Alert;
import eu.bilekpavel.vinotekalara.alertbar.domain.AlertBuilder;
import eu.bilekpavel.vinotekalara.alertbar.repository.AlertRepositoryInterface;
import eu.bilekpavel.vinotekalara.alertbar.dto.LocalizedAlert;
import eu.bilekpavel.vinotekalara.alertbar.config.AlertBarConfig;
import eu.bilekpavel.vinotekalara.translator.dto.LocalizedString;
import eu.bilekpavel.vinotekalara.translator.dto.LocalizedStringRequest;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import eu.bilekpavel.vinotekalara.translator.api.LocalizedStringFactoryInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlertBarService implements AlertServiceInterface {

    @Qualifier("alert_db_repository") private final AlertRepositoryInterface repo;
    private final LocalizedStringFactoryInterface localizedStringFactory;
    private final AlertBarConfig config;

    public AlertBarService(
            @Qualifier("alert_db_repository") AlertRepositoryInterface repo,
            LocalizedStringFactoryInterface localizedStringFactory,
            AlertBarConfig config
    ) {
        this.repo = repo;
        this.localizedStringFactory = localizedStringFactory;
        this.config = config;
    }

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
        Optional<Alert> optAlert = repo.findById(id);

        if (optAlert.isEmpty()) {
            return new LocalizedAlert(
                    0,
                    true,
                    localizedStringFactory.create("err", "Something went wrong"),
                    "tomato",
                    "black"
            );
        }

        Alert alert = optAlert.get();
        return alert.getLocalized(language) == null
                ? new LocalizedAlert(
                        alert.getId(),
                        alert.isActive(),
                        localizedStringFactory.create(language.getCode(), alert.getLocalized(language)),
                        alert.getBackgroundColor().toRgbString(),
                        alert.getFontColor().toRgbString())
                : new LocalizedAlert(
                        alert.getId(),
                        alert.isActive(),
                        localizedStringFactory.create(language.getCode(), alert.getLocalized(Language.CZECH)),
                        alert.getBackgroundColor().toRgbString(), alert.getFontColor().toRgbString());
    }

    @Override
    public List<LocalizedAlert> getAllLocalized(Language language, boolean allowRemoved) {
        return repo.findAll().stream()
                .filter(alert -> allowRemoved || !alert.isRemoved())
                .map(alert -> new LocalizedAlert(
                        alert.getId(),
                        alert.isActive(),
                        localizedStringFactory.create(language.getCode(), alert.getLocalized(language)),
                        alert.getBackgroundColor().toRgbString(),
                        alert.getFontColor().toRgbString())
                ).toList();
    }

    @Override
    public void updateBackgroundColor(int id, Color color) {
        Optional<Alert> optAlert = repo.findById(id);
        if (optAlert.isEmpty()) {
            return;
        }

        optAlert.get().setBackgroundColor(color);
        repo.save(optAlert.get());
    }

    @Override
    public void updateFontColor(int id, Color color) {
        Optional<Alert> optAlert = repo.findById(id);
        if (optAlert.isEmpty()) {
            return;
        }

        optAlert.get().setFontColor(color);
        repo.save(optAlert.get());
    }

    @Override
    public void updateLocalization(int id, LocalizedStringRequest request) {
        Optional<Alert> optAlert = repo.findById(id);
        if (optAlert.isEmpty()) {
            return;
        }
        LocalizedString content = localizedStringFactory.create(request);
        optAlert.get().updateLocalization(content);
    }

    @Override
    public Optional<AlertFullData> get(int id) {
        Optional<Alert> alert = repo.findById(id);
        return alert.map(value -> new AlertFullData(
                value.getId(),
                value.getLocalizations(),
                value.getBackgroundColor(),
                value.getFontColor()
        ));
    }

    @Override
    public void setActive(int id) {
        Optional<Alert> oldActive = repo.findByActive(true);
        Optional<Alert> newActive = repo.findById(id);

        if (newActive.isPresent()) {
            oldActive.ifPresent(alert -> alert.setActive(false));
            newActive.get().setActive(true);

            oldActive.ifPresent(alert -> repo.save(oldActive.get()));
            repo.save(newActive.get());
        }
    }

    @Override
    public LocalizedAlert getActive(Language language) {
        Optional<Alert> optActive = repo.findByActive(true);
        if (optActive.isEmpty()) {
            return new LocalizedAlert(
                    0,
                    true,
                    localizedStringFactory.create("err", "Something went wrong"),
                    "tomato",
                    "black"
            );
        }

        Alert alert = optActive.get();
        return new LocalizedAlert(
                alert.getId(),
                true,
                localizedStringFactory.create(language.getCode(), alert.getLocalized(language)),
                alert.getBackgroundColor().toRgbString(),
                alert.getFontColor().toRgbString()
        );
    }

    @Override
    public void allow(boolean isAllowed) {
        config.setAllowed(isAllowed);
    }

    @Override
    public void display(boolean isDisplayed) {
        config.setDisplayed(isDisplayed);
    }

    @Override
    public void toggle() {
        config.setDisplayed(!config.isDisplayed());
    }

    @Override
    public boolean isAllowed() {
        return config.isAllowed();
    }

    @Override
    public boolean isDisplayed() {
        return config.isDisplayed();
    }

    @Override
    public void delete(int id) {
        Optional<Alert> alert = repo.findById(id);
        if (alert.isPresent()) {
            if (alert.get().isActive()) {
                throw new RuntimeException("Cannot delete active alert");
            }
            alert.get().setRemoved(true);
            repo.save(alert.get());
        }
    }

    @Override
    public AlertBarWidgetData getWidgetData(Language lang) {
        return new AlertBarWidgetData(
                getAllLocalized(lang, false),
                isAllowed(),
                isDisplayed()
        );
    }
}
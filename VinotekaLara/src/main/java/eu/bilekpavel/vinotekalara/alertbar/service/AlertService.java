package eu.bilekpavel.vinotekalara.alertbar.service;

import eu.bilekpavel.vinotekalara.alertbar.dto.AlertBarWidgetData;
import eu.bilekpavel.vinotekalara.alertbar.dto.AlertFullData;
import eu.bilekpavel.vinotekalara.alertbar.dto.AlertRequest;
import eu.bilekpavel.vinotekalara.alertbar.error.AlertBarNotFoundException;
import eu.bilekpavel.vinotekalara.alertbar.error.CannotRemoveActiveAlertBarException;
import eu.bilekpavel.vinotekalara.alertbar.error.NoActiveAlertBarException;
import eu.bilekpavel.vinotekalara.alertbar.translator.AlertBarTranslator;
import eu.bilekpavel.vinotekalara.alertbar.translator.AlertBarTranslatorDataFactoryInterface;
import eu.bilekpavel.vinotekalara.alertbar.translator.dto.AlertBarTranslatorData;
import eu.bilekpavel.vinotekalara.app.module.color.dto.Color;
import eu.bilekpavel.vinotekalara.alertbar.model.Alert;
import eu.bilekpavel.vinotekalara.alertbar.model.AlertBuilder;
import eu.bilekpavel.vinotekalara.alertbar.repository.AlertRepositoryInterface;
import eu.bilekpavel.vinotekalara.alertbar.translator.dto.LocalizedAlert;
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
public final class AlertService implements AlertServiceInterface {

    @Qualifier("alert_db_repository") private final AlertRepositoryInterface repo;
    private final LocalizedStringFactoryInterface localizedStringFactory;
    private final AlertBarTranslatorDataFactoryInterface alertBarLocalizationProvider;
    private final AlertBarConfig config;

    public AlertService(
            @Qualifier("alert_db_repository") AlertRepositoryInterface repo,
            LocalizedStringFactoryInterface localizedStringFactory,
            AlertBarTranslatorDataFactoryInterface alertBarLocalizationProvider,
            AlertBarConfig config
    ) {
        this.repo = repo;
        this.localizedStringFactory = localizedStringFactory;
        this.alertBarLocalizationProvider = alertBarLocalizationProvider;
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
        Alert alert = getAlert(id);
        return alert.getContent(language) == null
                ? new LocalizedAlert(
                        alert.getId(),
                        alert.isActive(),
                        localizedStringFactory.create(language, alert.getContent(language)),
                        alert.getBackgroundColor().toRgbString(),
                        alert.getFontColor().toRgbString())
                : new LocalizedAlert(
                        alert.getId(),
                        alert.isActive(),
                        localizedStringFactory.create(language, alert.getContent(Language.CZECH)),
                        alert.getBackgroundColor().toRgbString(),
                        alert.getFontColor().toRgbString());
    }

    @Override
    public List<LocalizedAlert> getAllLocalized(Language language, boolean allowRemoved) {
        return repo.findAll().stream()
                .filter(alert -> allowRemoved || !alert.isRemoved())
                .map(alert -> new LocalizedAlert(
                        alert.getId(),
                        alert.isActive(),
                        localizedStringFactory.create(language, alert.getContent(language)),
                        alert.getBackgroundColor().toRgbString(),
                        alert.getFontColor().toRgbString())
                ).toList();
    }

    @Override
    public void updateBackgroundColor(int id, Color color) {
        Alert alert = getAlert(id);
        alert.setBackgroundColor(color);
        repo.save(alert);
    }

    @Override
    public void updateFontColor(int id, Color color) {
        Alert alert = getAlert(id);
        alert.setFontColor(color);
        repo.save(alert);
    }

    @Override
    public void updateColors(int id, Color background, Color font) {
        Alert alert = getAlert(id);
        alert.setBackgroundColor(background);
        alert.setFontColor(font);
        repo.save(alert);
    }

    @Override
    public void updateLocalization(int id, LocalizedStringRequest request) {
        Alert alert = getAlert(id);
        LocalizedString content = localizedStringFactory.create(request);
        alert.updateContent(content);
    }

    @Override
    public AlertFullData get(int id) {
        Alert alert = getAlert(id);
        return new AlertFullData(
                alert.getId(),
                alert.getContent(),
                alert.getBackgroundColor(),
                alert.getFontColor()
        );
    }

    @Override
    public void setActive(int id) {
        Optional<Alert> oldActive = repo.findByIsActive(true);
        Optional<Alert> newActive = repo.findById(id);

        if (newActive.isPresent()) {
            oldActive.ifPresent(Alert::setInactiveState);
            newActive.get().setActiveState();

            oldActive.ifPresent(alert -> repo.save(oldActive.get()));
            repo.save(newActive.get());
        }
    }

    @Override
    public LocalizedAlert getActive(Language language) throws NoActiveAlertBarException {
        Optional<Alert> optActive = repo.findByIsActive(true);
        if (optActive.isEmpty()) {
            throw new NoActiveAlertBarException();
        }

        Alert alert = optActive.get();
        return new LocalizedAlert(
                alert.getId(),
                true,
                localizedStringFactory.create(language, alert.getContent(language)),
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
                throw new CannotRemoveActiveAlertBarException();
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

    @Override
    public AlertBarTranslatorData getTranslatorData(AlertBarTranslator locale) {
        return alertBarLocalizationProvider.create(locale);
    }

    private Alert getAlert(int id) {
        Optional<Alert> optAlert = repo.findById(id);
        if (optAlert.isEmpty()) {
            throw new AlertBarNotFoundException(
                    String.valueOf(id)
            );
        }
        return optAlert.get();
    }
}
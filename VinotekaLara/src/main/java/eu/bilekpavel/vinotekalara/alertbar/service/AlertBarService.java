package eu.bilekpavel.vinotekalara.alertbar.service;

import eu.bilekpavel.vinotekalara.alertbar.dto.AlertRequest;
import eu.bilekpavel.vinotekalara.app.Color;
import eu.bilekpavel.vinotekalara.alertbar.model.Alert;
import eu.bilekpavel.vinotekalara.alertbar.model.AlertBuilder;
import eu.bilekpavel.vinotekalara.alertbar.repository.AlertBarRepositoryInterface;
import eu.bilekpavel.vinotekalara.alertbar.translator.LocalizedAlert;
import eu.bilekpavel.vinotekalara.translator.dto.LocalizedString;
import eu.bilekpavel.vinotekalara.translator.dto.LocalizedStringRequest;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import eu.bilekpavel.vinotekalara.translator.LocalizedStringFactoryInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AlertBarService implements AlertBarServiceInterface {

    private final AlertBarRepositoryInterface repo;
    private final LocalizedStringFactoryInterface localizedStringFactory;

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
                        localizedStringFactory.create(language.getCode(), alert.getLocalized(language)),
                        alert.getBackgroundColor())
                : new LocalizedAlert(
                        localizedStringFactory.create(language.getCode(), alert.getLocalized(Language.CZECH)),
                        alert.getBackgroundColor());
    }

    @Override
    public List<LocalizedAlert> getAllLocalized(Language language) {
        return repo.getAll().stream()
                .map((ab) -> new LocalizedAlert(
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
}
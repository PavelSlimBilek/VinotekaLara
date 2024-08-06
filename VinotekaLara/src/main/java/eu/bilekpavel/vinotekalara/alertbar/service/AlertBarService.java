package eu.bilekpavel.vinotekalara.alertbar.service;

import eu.bilekpavel.vinotekalara.alertbar.repository.AlertBarRepositoryInterface;
import eu.bilekpavel.vinotekalara.alertbar.translator.dto.TranslatedAlert;
import eu.bilekpavel.vinotekalara.translator.dto.Language;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AlertBarService implements AlertBarServiceInterface {

    private final AlertBarRepositoryInterface repo;

    @Override
    public List<TranslatedAlert> getAll(Language language) {
        return repo.getAll().stream()
                .map((alert -> new TranslatedAlert(language, alert.getLocalizedContent(language), alert.getBackgroundColor())))
                .toList();
    }
}

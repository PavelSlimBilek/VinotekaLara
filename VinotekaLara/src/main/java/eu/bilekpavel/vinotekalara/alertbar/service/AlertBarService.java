package eu.bilekpavel.vinotekalara.alertbar.service;

import eu.bilekpavel.vinotekalara.alertbar.repository.AlertRepositoryInterface;
import eu.bilekpavel.vinotekalara.alertbar.translator.TranslatedAlert;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AlertBarService implements AlertBarServiceInterface {

    private final AlertRepositoryInterface repo;

    @Override
    public List<TranslatedAlert> getAllTranslated(Language language) {
        return repo.getAll().stream()
                .map((alert -> new TranslatedAlert(language, alert.getLocalizedContent(language), alert.getBackgroundColor())))
                .toList();
    }
}
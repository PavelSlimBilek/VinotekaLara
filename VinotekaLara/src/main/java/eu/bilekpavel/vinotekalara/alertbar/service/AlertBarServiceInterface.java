package eu.bilekpavel.vinotekalara.alertbar.service;

import eu.bilekpavel.vinotekalara.alertbar.dto.AlertRequest;
import eu.bilekpavel.vinotekalara.app.Color;
import eu.bilekpavel.vinotekalara.alertbar.translator.LocalizedAlert;
import eu.bilekpavel.vinotekalara.translator.dto.LocalizedStringRequest;
import eu.bilekpavel.vinotekalara.translator.language.Language;

import java.util.List;

public interface AlertBarServiceInterface {
    void create(AlertRequest request);

    LocalizedAlert getLocalized(int id, Language language);
    List<LocalizedAlert> getAllLocalized(Language lang);

    void updateColor(int id, Color color);
    void updateLocalization(int id, LocalizedStringRequest request);
}
package eu.bilekpavel.vinotekalara.alertbar.service;

import eu.bilekpavel.vinotekalara.alertbar.dto.Color;
import eu.bilekpavel.vinotekalara.alertbar.translator.TranslatedAlert;
import eu.bilekpavel.vinotekalara.translator.language.Language;

import java.util.List;

public interface AlertBarServiceInterface {
    List<TranslatedAlert> getAllTranslated(Language language);

    void updateColor(Color color);
    void updateContent(Language lang, String content);
}
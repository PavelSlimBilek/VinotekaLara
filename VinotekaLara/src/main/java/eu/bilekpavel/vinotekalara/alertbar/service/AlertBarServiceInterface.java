package eu.bilekpavel.vinotekalara.alertbar.service;

import eu.bilekpavel.vinotekalara.alertbar.translator.dto.TranslatedAlert;
import eu.bilekpavel.vinotekalara.translator.dto.Language;

import java.util.List;

public interface AlertBarServiceInterface {
    List<TranslatedAlert> getAll(Language language);
}
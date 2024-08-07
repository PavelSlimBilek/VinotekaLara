package eu.bilekpavel.vinotekalara.alertbar.service;

import eu.bilekpavel.vinotekalara.alertbar.translator.TranslatedAlert;
import eu.bilekpavel.vinotekalara.translator.language.Language;

import java.util.List;

public interface AlertBarServiceInterface {
    List<TranslatedAlert> getAll(Language language);
}
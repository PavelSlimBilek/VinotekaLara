package eu.bilekpavel.vinotekalara.translator.repository;

import eu.bilekpavel.vinotekalara.translator.model.Localization;

import java.util.List;

public interface LocalizationRepositoryInterface {
    List<Localization> getAll();
}
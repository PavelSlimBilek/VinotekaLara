package eu.bilekpavel.vinotekalara.translator.service;

import eu.bilekpavel.vinotekalara.translator.model.Localization;
import eu.bilekpavel.vinotekalara.translator.repository.LocalizationRepositoryInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LocalizationService {

    private final LocalizationRepositoryInterface repo;

    public List<Localization> getAll() {
        return repo.getAll();
    }
}
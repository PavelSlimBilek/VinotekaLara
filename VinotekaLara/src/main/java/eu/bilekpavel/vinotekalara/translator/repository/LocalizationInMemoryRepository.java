package eu.bilekpavel.vinotekalara.translator.repository;

import eu.bilekpavel.vinotekalara.translator.dto.Flag;
import eu.bilekpavel.vinotekalara.translator.dto.Language;
import eu.bilekpavel.vinotekalara.translator.model.Localization;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public final class LocalizationInMemoryRepository implements LocalizationRepositoryInterface {

    private final List<Localization> localizations;

    public LocalizationInMemoryRepository() {
        localizations = new ArrayList<>();
        localizations.add(new Localization(
                Language.CZECH,
                new Flag(
                        "/images/translator/flags/flag_czech.png",
                        "česky"
                ),
                "cs"
        ));

        localizations.add(new Localization(
                Language.ENGLISH,
                new Flag(
                        "/images/translator/flags/flag_uk.png",
                        "english"
                ),
                "en"
        ));

        localizations.add(new Localization(
                Language.CZECH,
                new Flag(
                        "/images/translator/flags/flag_germany.png",
                        "deutsch"
                ),
                "de"
        ));
    }

    @Override
    public List<Localization> getAll() {
        return localizations;
    }
}
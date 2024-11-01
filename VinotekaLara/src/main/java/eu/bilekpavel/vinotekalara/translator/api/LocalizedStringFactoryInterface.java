package eu.bilekpavel.vinotekalara.translator.api;

import eu.bilekpavel.vinotekalara.translator.dto.LocalizedString;
import eu.bilekpavel.vinotekalara.translator.dto.LocalizedStringRequest;
import eu.bilekpavel.vinotekalara.translator.language.Language;

public interface LocalizedStringFactoryInterface {
    LocalizedString create(Language language, String content);
    LocalizedString create(LocalizedStringRequest request);
}

package eu.bilekpavel.vinotekalara.translator.api;

import eu.bilekpavel.vinotekalara.translator.dto.LocalizedString;
import eu.bilekpavel.vinotekalara.translator.dto.LocalizedStringRequest;

public interface LocalizedStringFactoryInterface {
    LocalizedString create(String code, String content);
    LocalizedString create(LocalizedStringRequest request);
}

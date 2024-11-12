package eu.bilekpavel.vinotekalara.translator.internal;

import eu.bilekpavel.vinotekalara.translator.api.LocalizedStringFactoryInterface;
import eu.bilekpavel.vinotekalara.translator.api.LocalizedStringValidatorInterface;
import eu.bilekpavel.vinotekalara.translator.dto.LocalizedString;
import eu.bilekpavel.vinotekalara.translator.dto.LocalizedStringRequest;
import eu.bilekpavel.vinotekalara.translator.error.TranslatorException;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public final class LocalizedStringFactory implements LocalizedStringFactoryInterface {

    private final TranslatorRegistry registry;
    private final LocalizedStringValidatorInterface validator;

    @Override
    public LocalizedString create(Language language, String content) {
        return new LocalizedString(language, content);
    }

    @Override
    public LocalizedString create(LocalizedStringRequest request) throws TranslatorException {
        validator.validate(request.langCode(), request.payload());
        Language language = registry.getLocale(request.langCode()).getLang();
        return new LocalizedString(language, request.payload());
    }
}

package eu.bilekpavel.vinotekalara.translator;

import eu.bilekpavel.vinotekalara.translator.dto.LocalizedString;
import eu.bilekpavel.vinotekalara.translator.dto.LocalizedStringRequest;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public final class LocalizedStringFactory implements LocalizedStringFactoryInterface {

    private final TranslatorRegistry registry;
    private final LocalizedStringValidatorInterface validator;

    @Override
    public LocalizedString create(String langCode, String content) {
        validator.validate(langCode, content);
        Language language = registry.getLocale(langCode).getLang();
        return new LocalizedString(language, content);
    }

    @Override
    public LocalizedString create(LocalizedStringRequest request) {
        validator.validate(request.langCode(), request.payload());
        Language language = registry.getLocale(request.langCode()).getLang();
        return new LocalizedString(language, request.payload());
    }
}

package eu.bilekpavel.vinotekalara.translator;

import eu.bilekpavel.vinotekalara.translator.dto.LocalizedString;
import eu.bilekpavel.vinotekalara.translator.dto.LocalizedStringRequest;
import eu.bilekpavel.vinotekalara.translator.error.LocalizedStringException;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * In addition, this class validates while impersonating LocalizedStringValidatorInterface
 */
@Component
@AllArgsConstructor
public final class LocalizedStringFactory implements
        LocalizedStringFactoryInterface,
        LocalizedStringValidatorInterface {

    private final TranslatorRegistry registry;

    @Override
    public LocalizedString create(String langCode, String content) {
        validate(langCode, content);
        Language language = registry.getLocale(langCode).getLang();
        return new LocalizedString(language, content);
    }

    @Override
    public LocalizedString create(LocalizedStringRequest request) {
        validate(request.langCode(), request.payload());
        Language language = registry.getLocale(request.langCode()).getLang();
        return new LocalizedString(language, request.payload());
    }

    // TODO this should be moved to separate LocalizedStringValidator
    @Override
    public void validate(String langCode, String content) {
        if (!registry.isOnTheList(langCode)) {
            throw new LocalizedStringException("Language code is not on the list");
        }

        if (content == null || content.isEmpty()) {
            throw new LocalizedStringException("Content is empty");
        }
    }
}

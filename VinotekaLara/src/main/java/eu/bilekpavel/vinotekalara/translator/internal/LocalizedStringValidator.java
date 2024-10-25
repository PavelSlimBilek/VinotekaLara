package eu.bilekpavel.vinotekalara.translator.internal;

import eu.bilekpavel.vinotekalara.translator.api.LocalizedStringValidatorInterface;
import eu.bilekpavel.vinotekalara.translator.error.InvalidLangCodeTranslatorException;
import eu.bilekpavel.vinotekalara.translator.error.TranslatorException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public final class LocalizedStringValidator implements LocalizedStringValidatorInterface {

    TranslatorRegistry registry;

    @Override
    public void validate(String langCode, String payload) throws TranslatorException {
        if (!registry.isOnTheList(langCode)) {
            throw new InvalidLangCodeTranslatorException("Language langCode is not on the list");
        }

        if (payload == null || payload.isEmpty()) {
            throw new RuntimeException("Content is empty");
        }
    }
}

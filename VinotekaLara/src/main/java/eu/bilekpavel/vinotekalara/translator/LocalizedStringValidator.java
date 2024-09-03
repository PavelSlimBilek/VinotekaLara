package eu.bilekpavel.vinotekalara.translator;

import eu.bilekpavel.vinotekalara.translator.error.LocalizedStringException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LocalizedStringValidator implements LocalizedStringValidatorInterface {

    TranslatorRegistry registry;

    @Override
    public void validate(String langCode, String payload) throws LocalizedStringException {
        if (!registry.isOnTheList(langCode)) {
            throw new LocalizedStringException("Language langCode is not on the list");
        }

        if (payload == null || payload.isEmpty()) {
            throw new LocalizedStringException("Content is empty");
        }
    }
}

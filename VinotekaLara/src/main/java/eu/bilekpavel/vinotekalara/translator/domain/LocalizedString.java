package eu.bilekpavel.vinotekalara.translator.domain;

import eu.bilekpavel.vinotekalara.translator.dto.LocalizedStringRequest;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import lombok.Getter;
import lombok.NonNull;

// TODO Entity to be
@Getter
public class LocalizedString {
    private final Language language;
    private final String content;

    public LocalizedString(@NonNull LocalizedStringRequest request) {
        this.language = request.language();
        this.content = request.payload();
    }
}
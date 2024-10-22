package eu.bilekpavel.vinotekalara.app.core.translator.internal.languages;

import eu.bilekpavel.vinotekalara.app.core.translator.internal.AbstractCoreTranslator;
import org.springframework.stereotype.Component;

@Component
public final class CzechCoreTranslator extends AbstractCoreTranslator {
    public CzechCoreTranslator() {
        super(
                "APPLICATION",
                "SETTINGS",
                "PREVIEW",
                "NAME",
                "ALLOW",
                "ALLOWED",
                "FORBID",
                "FORBIDDEN",
                "ACTIVATE",
                "SUBMIT",
                "EDIT",
                "BACK",
                "DELETE",
                "CREATE",
                "APPLY"
        );
    }
}

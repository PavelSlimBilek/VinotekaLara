package eu.bilekpavel.vinotekalara.app.translator.internal.languages;

import eu.bilekpavel.vinotekalara.app.translator.internal.AbstractCoreTranslator;
import org.springframework.stereotype.Component;

@Component
public final class SampleAlertBarTranslator extends AbstractCoreTranslator {

    public SampleAlertBarTranslator() {
        super(
                "APPLICATION",
                "SETTINGS",
                "CONTENT",
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
                "APPLY",
                "TRANSLATOR"
        );
    }
}

package eu.bilekpavel.vinotekalara.superadmin.translator.internal.languages;

import eu.bilekpavel.vinotekalara.superadmin.translator.internal.AbstractAdminPageTranslator;
import org.springframework.stereotype.Component;

@Component
public final class SampleAdminPageTranslator extends AbstractAdminPageTranslator {

    public SampleAdminPageTranslator() {
        super(
                "TITLE"
        );
    }
}

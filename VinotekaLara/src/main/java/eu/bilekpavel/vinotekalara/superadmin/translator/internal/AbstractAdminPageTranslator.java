package eu.bilekpavel.vinotekalara.superadmin.translator.internal;

import eu.bilekpavel.vinotekalara.superadmin.translator.AdminPageTranslator;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class AbstractAdminPageTranslator implements AdminPageTranslator {
    private final String TITLE;

    @Override
    public String title() {
        return TITLE;
    }
}
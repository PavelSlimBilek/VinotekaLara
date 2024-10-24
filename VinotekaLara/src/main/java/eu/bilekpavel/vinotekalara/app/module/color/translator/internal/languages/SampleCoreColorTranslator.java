package eu.bilekpavel.vinotekalara.app.module.color.translator.internal.languages;

import eu.bilekpavel.vinotekalara.app.module.color.translator.internal.AbstractCoreColorTranslator;
import org.springframework.stereotype.Component;

@Component
public final class SampleCoreColorTranslator extends AbstractCoreColorTranslator {

    public SampleCoreColorTranslator() {
        super(
                "COLOR",
                "COLORS",
                "SELECT_COLOR",
                "SELECT_COLORS",
                "FAVORITE_COLOR",
                "PALETTE",
                "RED",
                "GREEN",
                "BLUE"
        );
    }
}

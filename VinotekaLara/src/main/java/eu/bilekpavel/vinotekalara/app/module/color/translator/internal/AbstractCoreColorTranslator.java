package eu.bilekpavel.vinotekalara.app.module.color.translator.internal;

import eu.bilekpavel.vinotekalara.app.module.color.translator.CoreColorTranslator;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class AbstractCoreColorTranslator implements CoreColorTranslator {
    private final String RED;
    private final String GREEN;
    private final String BLUE;

    @Override
    public String red() {
        return RED;
    }

    @Override
    public String green() {
        return GREEN;
    }

    @Override
    public String blue() {
        return BLUE;
    }
}

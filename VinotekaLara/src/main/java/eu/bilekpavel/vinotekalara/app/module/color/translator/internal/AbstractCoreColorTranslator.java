package eu.bilekpavel.vinotekalara.app.module.color.translator.internal;

import eu.bilekpavel.vinotekalara.app.module.color.translator.CoreColorTranslator;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AbstractCoreColorTranslator implements CoreColorTranslator {
    private final String COLOR;
    private final String COLORS;
    private final String SELECT_COLOR;
    private final String SELECT_COLORS;
    private final String FAVORITE_COLOR;

    private final String PALETTE;

    private final String RED;
    private final String GREEN;
    private final String BLUE;

    @Override
    public String color() {
        return COLOR;
    }

    @Override
    public String colors() {
        return COLORS;
    }

    @Override
    public String selectColor() {
        return SELECT_COLOR;
    }

    @Override
    public String selectColors() {
        return SELECT_COLORS;
    }

    @Override
    public String favoriteColor() {
        return FAVORITE_COLOR;
    }

    @Override
    public String palette() {
        return PALETTE;
    }

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

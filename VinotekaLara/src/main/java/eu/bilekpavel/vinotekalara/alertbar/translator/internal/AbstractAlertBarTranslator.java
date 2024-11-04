package eu.bilekpavel.vinotekalara.alertbar.translator.internal;

import eu.bilekpavel.vinotekalara.alertbar.translator.AlertBarTranslator;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class AbstractAlertBarTranslator implements AlertBarTranslator {
    private final String ALERT_BAR;
    private final String ALLOW_ALERT_BAR;
    private final String DISPLAY_ALERT_BAR;
    private final String SELECT_ACTIVE_ALERT_BAR;
    private final String CREATE_ALERT_BAR;
    private final String BACKGROUND_COLOR;
    private final String FONT_COLOR;

    @Override
    public String allowAlertBar() {
        return ALLOW_ALERT_BAR;
    }

    @Override
    public String displayAlertBar() {
        return DISPLAY_ALERT_BAR;
    }

    @Override
    public String selectActiveAlertBar() {
        return SELECT_ACTIVE_ALERT_BAR;
    }

    @Override
    public String createAlertBar() {
        return CREATE_ALERT_BAR;
    }

    @Override
    public String alertBar() {
        return ALERT_BAR;
    }

    @Override
    public String backgroundColor() {
        return BACKGROUND_COLOR;
    }

    @Override
    public String fontColor() {
        return FONT_COLOR;
    }
}

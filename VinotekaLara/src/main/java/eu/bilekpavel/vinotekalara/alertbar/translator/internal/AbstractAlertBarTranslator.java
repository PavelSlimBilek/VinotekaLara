package eu.bilekpavel.vinotekalara.alertbar.translator.internal;

import eu.bilekpavel.vinotekalara.alertbar.translator.AlertBarTranslator;

public abstract class AbstractAlertBarTranslator implements AlertBarTranslator {
    private final String ALERT_BAR;
    private final String ALLOW_ALERT_BAR;
    private final String DISPLAY_ALERT_BAR;
    private final String SELECT_ACTIVE_ALERT_BAR;
    private final String CREATE_ALERT_BAR;

    protected AbstractAlertBarTranslator (
            String alertBar,
            String allowAlertBar,
            String displayAlertBar,
            String selectAlertBar,
            String createAlertBar
    ) {
            this.ALERT_BAR = alertBar;
            this.ALLOW_ALERT_BAR = allowAlertBar;
            this.DISPLAY_ALERT_BAR = displayAlertBar;
            this.SELECT_ACTIVE_ALERT_BAR = selectAlertBar;
            this.CREATE_ALERT_BAR = createAlertBar;
    }

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
}

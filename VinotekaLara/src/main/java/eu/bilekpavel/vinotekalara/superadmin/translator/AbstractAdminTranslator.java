package eu.bilekpavel.vinotekalara.superadmin.translator;

public class AbstractAdminTranslator implements AdminTranslatorInterface {
    public final String SETTINGS_TRANSLATION;
    public final String OPENING_HOURS_TRANSLATION;
    public final String APP_TRANSLATION;
    public final String ALERT_BAR_TRANSLATION;
    public final String ALLOW_TRANSLATION;
    public final String FORBID_TRANSLATION;
    public final String ACTIVATE_TRANSLATION;
    public final String SUBMIT_TRANSLATION;
    public final String EDIT_TRANSLATION;
    public final String BACK_TRANSLATION;

    public final String SELECT_GLOBAL_HOURS_TRANSLATION;
    public final String ACTIVE_HOURS_TRANSLATION;


    public AbstractAdminTranslator(
            String settingsTranslation,
            String openingHoursTranslation,
            String appTranslation,
            String alertbarTranslation,
            String allowTranslation,
            String forbidTranslation,
            String activateTranslation,
            String submitTranslation,
            String editTranslation,
            String backTranslation,
            String selectGlobalHoursTranslation,
            String activeHoursTranslation
    ) {
        this.SETTINGS_TRANSLATION = settingsTranslation;
        this.OPENING_HOURS_TRANSLATION = openingHoursTranslation;
        this.APP_TRANSLATION = appTranslation;
        this.ALERT_BAR_TRANSLATION = alertbarTranslation;
        this.ALLOW_TRANSLATION = allowTranslation;
        this.FORBID_TRANSLATION = forbidTranslation;
        this.ACTIVATE_TRANSLATION = activateTranslation;
        this.SUBMIT_TRANSLATION = submitTranslation;
        this.EDIT_TRANSLATION = editTranslation;
        this.BACK_TRANSLATION = backTranslation;

        this.SELECT_GLOBAL_HOURS_TRANSLATION = selectGlobalHoursTranslation;
        this.ACTIVE_HOURS_TRANSLATION = activeHoursTranslation;
    }

    @Override
    public String getSettingsTranslation() {
        return SETTINGS_TRANSLATION;
    }

    @Override
    public String getOpeningHoursTranslation() {
        return OPENING_HOURS_TRANSLATION;
    }

    @Override
    public String getAppTranslation() {
        return APP_TRANSLATION;
    }

    @Override
    public String getAlertBarTranslation() {
        return ALERT_BAR_TRANSLATION;
    }

    @Override
    public String getAllowTranslation() {
        return ALLOW_TRANSLATION;
    }

    @Override
    public String getForbidTranslation() {
        return FORBID_TRANSLATION;
    }

    @Override
    public String getActivateTranslation() {
        return ACTIVATE_TRANSLATION;
    }

    @Override
    public String getSubmitTranslation() {
        return SUBMIT_TRANSLATION;
    }

    @Override
    public String getEditTranslation() {
        return EDIT_TRANSLATION;
    }

    @Override
    public String getBackTranslation() {
        return BACK_TRANSLATION;
    }

    @Override
    public String getSelectGlobalHoursTranslation() {
        return SELECT_GLOBAL_HOURS_TRANSLATION;
    }

    @Override
    public String getActiveHoursTranslation() {
        return ACTIVE_HOURS_TRANSLATION;
    }
}
package eu.bilekpavel.vinotekalara.superadmin.translator;

public abstract class AbstractAdminTranslator implements AdminTranslatorInterface {
    private final String SETTINGS_TRANSLATION;
    private final String OPENING_HOURS_TRANSLATION;
    private final String APP_TRANSLATION;
    private final String ALERT_BAR_TRANSLATION;
    private final String ALLOW_TRANSLATION;
    private final String FORBID_TRANSLATION;
    private final String ACTIVATE_TRANSLATION;
    private final String SUBMIT_TRANSLATION;
    private final String EDIT_TRANSLATION;
    private final String BACK_TRANSLATION;
    private final String DELETE_TRANSLATION;
    private final String CREATE_TRANSLATION;
    private final String NAME_TRANSLATION;
    private final String APPLY_TRANSLATION;
    private final String APP_SETTINGS_TRANSLATION;
    private final String PREVIEW_TRANSLATION;

    private final String SELECT_GLOBAL_HOURS_TRANSLATION;
    private final String ACTIVE_HOURS_TRANSLATION;
    private final String SET_OPENING_HOURS_TRANSLATION;

    private final String SELECT_DEFAULT_LANGUAGE_TRANSLATION;
    private final String TOGGLE_LANGUAGES_MESSAGE_TRANSLATION;

    private final String ALLOW_ALERT_BAR_TRANSLATION;
    private final String DISPLAY_ALERT_BAR_TRANSLATION;
    private final String SELECT_ACTIVE_ALERT_TRANSLATION;
    private final String CREATE_ALERT_BAR_TRANSLATION;

    private final String UPDATE_LOCALIZATIONS_TRANSLATION;
    private final String BACKGROUND_COLOR_TRANSLATION;
    private final String FONT_COLOR_TRANSLATION;
    private final String SELECT_FONT_TRANSLATION;
    private final String RED_TRANSLATION;
    private final String GREEN_TRANSLATION;
    private final String BLUE_TRANSLATION;

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
            String activeHoursTranslation,
            String deleteTranslation,
            String createTranslation,
            String nameTranslation,
            String applyTranslation,
            String selectLanguageTranslation,
            String toggleLanguagesMessageTranslation,
            String appSettingsTranslation,
            String allowAlertBarTranslation,
            String displayAlertBarTranslation,
            String selectActiveAlertTranslation,
            String createAlertBarTranslation,
            String updateLocalizationsTranslation,
            String backgroundColorTranslation,
            String redTranslation,
            String greenTranslation,
            String blueTranslation,
            String setOpeningHoursTranslation,
            String fontColorTranslation,
            String selectFontTranslation,
            String previewTranslation
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
        this.DELETE_TRANSLATION = deleteTranslation;
        this.CREATE_TRANSLATION = createTranslation;
        this.NAME_TRANSLATION = nameTranslation;
        this.APPLY_TRANSLATION = applyTranslation;
        this.APP_SETTINGS_TRANSLATION = appSettingsTranslation;
        this.PREVIEW_TRANSLATION = previewTranslation;

        this.SELECT_GLOBAL_HOURS_TRANSLATION = selectGlobalHoursTranslation;
        this.ACTIVE_HOURS_TRANSLATION = activeHoursTranslation;
        this.SET_OPENING_HOURS_TRANSLATION = setOpeningHoursTranslation;

        this.SELECT_DEFAULT_LANGUAGE_TRANSLATION = selectLanguageTranslation;
        this.TOGGLE_LANGUAGES_MESSAGE_TRANSLATION = toggleLanguagesMessageTranslation;

        this.ALLOW_ALERT_BAR_TRANSLATION = allowAlertBarTranslation;
        this.DISPLAY_ALERT_BAR_TRANSLATION = displayAlertBarTranslation;
        this.SELECT_ACTIVE_ALERT_TRANSLATION = selectActiveAlertTranslation;
        this.CREATE_ALERT_BAR_TRANSLATION = createAlertBarTranslation;
        this.FONT_COLOR_TRANSLATION = fontColorTranslation;
        this.SELECT_FONT_TRANSLATION = selectFontTranslation;

        this.UPDATE_LOCALIZATIONS_TRANSLATION = updateLocalizationsTranslation;
        this.BACKGROUND_COLOR_TRANSLATION = backgroundColorTranslation;
        this.RED_TRANSLATION = redTranslation;
        this.GREEN_TRANSLATION = greenTranslation;
        this.BLUE_TRANSLATION = blueTranslation;
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
    public String getDeleteTranslation() {
        return DELETE_TRANSLATION;
    }

    @Override
    public String getNameTranslation() {
        return NAME_TRANSLATION;
    }

    @Override
    public String getPreviewTranslation() {
        return PREVIEW_TRANSLATION;
    }

    @Override
    public String getApplyTranslation() {
        return APPLY_TRANSLATION;
    }

    @Override
    public String getCreateTranslation() {
        return CREATE_TRANSLATION;
    }

    @Override
    public String getSelectGlobalHoursTranslation() {
        return SELECT_GLOBAL_HOURS_TRANSLATION;
    }

    @Override
    public String getSelectDefaultLanguageTranslation() {
        return SELECT_DEFAULT_LANGUAGE_TRANSLATION;
    }

    @Override
    public String getToggleLanguagesMessage() {
        return TOGGLE_LANGUAGES_MESSAGE_TRANSLATION;
    }

    @Override
    public String getAppSettingsTranslation() {
        return APP_SETTINGS_TRANSLATION;
    }

    @Override
    public String getAllowAlertBarTranslation() {
        return ALLOW_ALERT_BAR_TRANSLATION;
    }

    @Override
    public String getDisplayAlertBarTranslation() {
        return DISPLAY_ALERT_BAR_TRANSLATION;
    }

    @Override
    public String getSelectActiveAlertTranslation() {
        return SELECT_ACTIVE_ALERT_TRANSLATION;
    }

    @Override
    public String getCreateAlertBarTranslation() {
        return CREATE_ALERT_BAR_TRANSLATION;
    }

    @Override
    public String getUpdateLocalizationsTranslation() {
        return UPDATE_LOCALIZATIONS_TRANSLATION;
    }

    @Override
    public String getBackgroundColorTranslation() {
        return BACKGROUND_COLOR_TRANSLATION;
    }

    @Override
    public String getRedTranslation() {
        return RED_TRANSLATION;
    }

    @Override
    public String getBlueTranslation() {
        return BLUE_TRANSLATION;
    }

    @Override
    public String getGreenTranslation() {
        return GREEN_TRANSLATION;
    }

    @Override
    public String getSetOpeningHoursTranslation() {
        return SET_OPENING_HOURS_TRANSLATION;
    }

    @Override
    public String getFontColorTranslation() {
        return FONT_COLOR_TRANSLATION;
    }

    @Override
    public String getSelectFontTranslation() {
        return SELECT_FONT_TRANSLATION;
    }

    @Override
    public String getActiveHoursTranslation() {
        return ACTIVE_HOURS_TRANSLATION;
    }
}
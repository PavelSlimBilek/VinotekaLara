package eu.bilekpavel.vinotekalara.superadmin.translator;

public abstract class AbstractAdminTranslator implements AdminTranslatorInterface {
    private final String SETTINGS_TRANSLATION;
    private final String APP_TRANSLATION;
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

    private final String SELECT_DEFAULT_LANGUAGE_TRANSLATION;
    private final String TOGGLE_LANGUAGES_MESSAGE_TRANSLATION;

    private final String UPDATE_LOCALIZATIONS_TRANSLATION;
    private final String BACKGROUND_COLOR_TRANSLATION;
    private final String FONT_COLOR_TRANSLATION;
    private final String SELECT_FONT_TRANSLATION;
    private final String RED_TRANSLATION;
    private final String GREEN_TRANSLATION;
    private final String BLUE_TRANSLATION;

    public AbstractAdminTranslator(
            String settingsTranslation,
            String appTranslation,
            String allowTranslation,
            String forbidTranslation,
            String activateTranslation,
            String submitTranslation,
            String editTranslation,
            String backTranslation,
            String deleteTranslation,
            String createTranslation,
            String nameTranslation,
            String applyTranslation,
            String selectLanguageTranslation,
            String toggleLanguagesMessageTranslation,
            String appSettingsTranslation,
            String updateLocalizationsTranslation,
            String backgroundColorTranslation,
            String redTranslation,
            String greenTranslation,
            String blueTranslation,
            String fontColorTranslation,
            String selectFontTranslation,
            String previewTranslation
    ) {
        this.SETTINGS_TRANSLATION = settingsTranslation;
        this.APP_TRANSLATION = appTranslation;
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

        this.SELECT_DEFAULT_LANGUAGE_TRANSLATION = selectLanguageTranslation;
        this.TOGGLE_LANGUAGES_MESSAGE_TRANSLATION = toggleLanguagesMessageTranslation;

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
    public String getAppTranslation() {
        return APP_TRANSLATION;
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
    public String getFontColorTranslation() {
        return FONT_COLOR_TRANSLATION;
    }

    @Override
    public String getSelectFontTranslation() {
        return SELECT_FONT_TRANSLATION;
    }
}
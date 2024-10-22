package eu.bilekpavel.vinotekalara.superadmin.translator;

public abstract class AbstractAdminTranslator implements AdminTranslatorInterface {
    private final String APP_SETTINGS_TRANSLATION;

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
            String selectLanguageTranslation,
            String toggleLanguagesMessageTranslation,
            String appSettingsTranslation,
            String updateLocalizationsTranslation,
            String backgroundColorTranslation,
            String redTranslation,
            String greenTranslation,
            String blueTranslation,
            String fontColorTranslation,
            String selectFontTranslation
    ) {
        this.APP_SETTINGS_TRANSLATION = appSettingsTranslation;

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
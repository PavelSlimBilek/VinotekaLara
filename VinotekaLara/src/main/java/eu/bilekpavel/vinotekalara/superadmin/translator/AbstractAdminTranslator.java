package eu.bilekpavel.vinotekalara.superadmin.translator;

public class AbstractAdminTranslator implements AdminTranslatorInterface {
    public final String openingHoursTranslation;
    public final String appTranslation;
    public final String alertbarTranslation;

    public AbstractAdminTranslator(
            String openingHoursTranslation,
            String appTranslation,
            String alertbarTranslation
    ) {
        this.openingHoursTranslation = openingHoursTranslation;
        this.appTranslation = appTranslation;
        this.alertbarTranslation = alertbarTranslation;
    }

    @Override
    public String getOpeningHoursTranslation() {
        return openingHoursTranslation;
    }

    @Override
    public String getAppTranslation() {
        return appTranslation;
    }

    @Override
    public String getAlertBarTranslation() {
        return alertbarTranslation;
    }
}
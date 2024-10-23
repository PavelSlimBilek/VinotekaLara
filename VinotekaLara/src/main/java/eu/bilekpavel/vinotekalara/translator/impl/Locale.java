package eu.bilekpavel.vinotekalara.translator.impl;

import eu.bilekpavel.vinotekalara.alertbar.translator.AlertBarTranslator;
import eu.bilekpavel.vinotekalara.app.module.color.translator.CoreColorTranslator;
import eu.bilekpavel.vinotekalara.app.translator.CoreTranslator;
import eu.bilekpavel.vinotekalara.homepage.translator.HomePageTranslator;
import eu.bilekpavel.vinotekalara.openinghours.translator.OpeningHoursTranslator;
import eu.bilekpavel.vinotekalara.superadmin.translator.AdminPageTranslator;
import eu.bilekpavel.vinotekalara.translator.api.Translator;
import eu.bilekpavel.vinotekalara.translator.dto.Flag;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class Locale implements Translator {
    private final Language language;
    private final Flag flag;

    // CORE
    private final CoreTranslator coreTranslator;
    private final CoreColorTranslator coreColorTranslator;
    private final AdminPageTranslator adminTranslator;
    private final HomePageTranslator homePageTranslator;

    // MODULES
    private final OpeningHoursTranslator hoursTranslator;
    private final AlertBarTranslator alertBarTranslator;

    @Override
    public String getCode() {
        return language.getCode();
    }

    @Override
    public Flag getFlag() {
        return flag;
    }

    @Override
    public Language getLang() {
        return language;
    }


    // composite translators
    @Override
    public CoreTranslator coreTranslator() {
        return coreTranslator;
    }

    @Override
    public CoreColorTranslator coreColorTranslator() {
        return coreColorTranslator;
    }

    @Override
    public HomePageTranslator homePageTranslator() {
        return homePageTranslator;
    }

    @Override
    public OpeningHoursTranslator hoursTranslator() {
        return hoursTranslator;
    }

    @Override
    public AdminPageTranslator getAdminTranslator() {
        return adminTranslator;
    }

    @Override
    public AlertBarTranslator alertTranslator() {
        return alertBarTranslator;
    }
}
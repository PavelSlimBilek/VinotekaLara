package eu.bilekpavel.vinotekalara.translator.impl;

import eu.bilekpavel.vinotekalara.alertbar.translator.AlertBarTranslator;
import eu.bilekpavel.vinotekalara.app.core.translator.CoreTranslator;
import eu.bilekpavel.vinotekalara.homepage.translator.HomePageTranslatorInterface;
import eu.bilekpavel.vinotekalara.openinghours.translator.OpeningHoursTranslator;
import eu.bilekpavel.vinotekalara.superadmin.translator.AdminTranslatorInterface;
import eu.bilekpavel.vinotekalara.translator.api.Translator;
import eu.bilekpavel.vinotekalara.translator.dto.Flag;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class Locale implements Translator {
    private final Language language;

    private final Flag flag;

    private final CoreTranslator coreTranslator;
    private final OpeningHoursTranslator hoursTranslator;
    private final HomePageTranslatorInterface pageTranslator;
    private final AdminTranslatorInterface adminTranslator;
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


    @Override
    public CoreTranslator coreTranslator() {
        return coreTranslator;
    }

    @Override
    public HomePageTranslatorInterface getPageTranslator() {
        return pageTranslator;
    }

    @Override
    public OpeningHoursTranslator hoursTranslator() {
        return hoursTranslator;
    }

    @Override
    public AdminTranslatorInterface getAdminTranslator() {
        return adminTranslator;
    }

    @Override
    public AlertBarTranslator alertTranslator() {
        return alertBarTranslator;
    }
}
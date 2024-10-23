package eu.bilekpavel.vinotekalara.translator.api;

import eu.bilekpavel.vinotekalara.alertbar.translator.AlertBarTranslator;
import eu.bilekpavel.vinotekalara.app.module.color.translator.CoreColorTranslator;
import eu.bilekpavel.vinotekalara.app.translator.CoreTranslator;
import eu.bilekpavel.vinotekalara.homepage.translator.HomePageTranslator;
import eu.bilekpavel.vinotekalara.openinghours.translator.OpeningHoursTranslator;
import eu.bilekpavel.vinotekalara.superadmin.translator.AdminPageTranslator;
import eu.bilekpavel.vinotekalara.translator.dto.Flag;
import eu.bilekpavel.vinotekalara.translator.language.Language;

public interface Translator {
    Language getLang();

    String getCode();
    Flag getFlag();

    CoreTranslator coreTranslator();
    CoreColorTranslator coreColorTranslator();
    HomePageTranslator homePageTranslator();
    OpeningHoursTranslator hoursTranslator();
    AdminPageTranslator getAdminTranslator();
    AlertBarTranslator alertTranslator();
}
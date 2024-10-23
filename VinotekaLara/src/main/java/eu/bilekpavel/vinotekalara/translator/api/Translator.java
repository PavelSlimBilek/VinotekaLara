package eu.bilekpavel.vinotekalara.translator.api;

import eu.bilekpavel.vinotekalara.alertbar.translator.AlertBarTranslator;
import eu.bilekpavel.vinotekalara.app.module.color.translator.CoreColorTranslator;
import eu.bilekpavel.vinotekalara.app.translator.CoreTranslator;
import eu.bilekpavel.vinotekalara.homepage.translator.HomePageTranslator;
import eu.bilekpavel.vinotekalara.openinghours.translator.OpeningHoursTranslator;
import eu.bilekpavel.vinotekalara.superadmin.translator.AdminPageTranslator;
import eu.bilekpavel.vinotekalara.translator.dto.Flag;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import eu.bilekpavel.vinotekalara.translator.translator.TranslatorTranslator;

public interface Translator {
    Language getLang();

    String getCode();
    Flag getFlag();

    CoreTranslator coreTranslator();
    TranslatorTranslator translatorTranslator();
    CoreColorTranslator coreColorTranslator();
    HomePageTranslator homePageTranslator();
    AdminPageTranslator getAdminTranslator();

    AlertBarTranslator alertTranslator();
    OpeningHoursTranslator hoursTranslator();
}
package eu.bilekpavel.vinotekalara.translator.api;

import eu.bilekpavel.vinotekalara.alertbar.translator.AlertBarTranslator;
import eu.bilekpavel.vinotekalara.app.core.translator.CoreTranslator;
import eu.bilekpavel.vinotekalara.homepage.translator.HomePageTranslatorInterface;
import eu.bilekpavel.vinotekalara.openinghours.translator.OpeningHoursTranslator;
import eu.bilekpavel.vinotekalara.superadmin.translator.AdminTranslatorInterface;
import eu.bilekpavel.vinotekalara.translator.dto.Flag;
import eu.bilekpavel.vinotekalara.translator.language.Language;

public interface Translator {
    Language getLang();

    String getCode();
    Flag getFlag();

    CoreTranslator coreTranslator();
    HomePageTranslatorInterface getPageTranslator();
    OpeningHoursTranslator hoursTranslator();
    AdminTranslatorInterface getAdminTranslator();
    AlertBarTranslator alertTranslator();
}
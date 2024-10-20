package eu.bilekpavel.vinotekalara.translator.api;

import eu.bilekpavel.vinotekalara.homepage.translator.HomePageTranslatorInterface;
import eu.bilekpavel.vinotekalara.openinghours.translator.OpeningHoursTranslatorInterface;
import eu.bilekpavel.vinotekalara.superadmin.translator.AdminTranslatorInterface;
import eu.bilekpavel.vinotekalara.translator.dto.Flag;
import eu.bilekpavel.vinotekalara.translator.language.Language;

public interface Translator {
    Language getLang();

    String getCode();
    Flag getFlag();

    boolean isAllowed();
    Translator allow(boolean isAllowed);

    HomePageTranslatorInterface getPageTranslator();
    OpeningHoursTranslatorInterface getHoursTranslator();
    AdminTranslatorInterface getAdminTranslator();
}
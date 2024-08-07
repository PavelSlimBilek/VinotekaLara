package eu.bilekpavel.vinotekalara.translator;

import eu.bilekpavel.vinotekalara.front.translator.HomePageTranslatorInterface;
import eu.bilekpavel.vinotekalara.openinghours.translator.OpeningHoursTranslatorInterface;
import eu.bilekpavel.vinotekalara.translator.dto.Flag;
import eu.bilekpavel.vinotekalara.translator.language.Language;

public interface Translator {
    String getCode();
    Language getLang();
    Flag getFlag();

    HomePageTranslatorInterface getPageTranslator();
    OpeningHoursTranslatorInterface getHoursTranslator();
}
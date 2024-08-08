package eu.bilekpavel.vinotekalara.translator;

import eu.bilekpavel.vinotekalara.view.translator.HomePageTranslatorInterface;
import eu.bilekpavel.vinotekalara.openinghours.translator.OpeningHoursTranslatorInterface;
import eu.bilekpavel.vinotekalara.translator.dto.Flag;
import eu.bilekpavel.vinotekalara.translator.language.Language;

public abstract class Locale implements Translator {
    public final Language language;
    public final String code;

    public final Flag flag;

    public final OpeningHoursTranslatorInterface hoursTranslator;
    public final HomePageTranslatorInterface pageTranslator;

    public Locale(
            Language language,
            String code,
            Flag flag,
            OpeningHoursTranslatorInterface hoursTranslator,
            HomePageTranslatorInterface pageTranslator
    ) {
        this.language = language;
        this.code = code;
        this.flag = flag;
        this.hoursTranslator = hoursTranslator;
        this.pageTranslator = pageTranslator;
    }

    @Override
    public String getCode() {
        return code;
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
    public HomePageTranslatorInterface getPageTranslator() {
        return pageTranslator;
    }

    @Override
    public OpeningHoursTranslatorInterface getHoursTranslator() {
        return hoursTranslator;
    }
}
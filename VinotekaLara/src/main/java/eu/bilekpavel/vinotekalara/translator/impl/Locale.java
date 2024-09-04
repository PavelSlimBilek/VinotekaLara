package eu.bilekpavel.vinotekalara.translator.impl;

import eu.bilekpavel.vinotekalara.homepage.translator.HomePageTranslatorInterface;
import eu.bilekpavel.vinotekalara.openinghours.translator.OpeningHoursTranslatorInterface;
import eu.bilekpavel.vinotekalara.translator.api.Translator;
import eu.bilekpavel.vinotekalara.translator.dto.Flag;
import eu.bilekpavel.vinotekalara.translator.language.Language;

public abstract class Locale implements Translator {
    private boolean isAllowed = true; // allow locale as
    private final Language language;

    private final Flag flag;

    private final OpeningHoursTranslatorInterface hoursTranslator;
    private final HomePageTranslatorInterface pageTranslator;

    public Locale(
            Language language,
            Flag flag,
            OpeningHoursTranslatorInterface hoursTranslator,
            HomePageTranslatorInterface pageTranslator
    ) {
        this.language = language;
        this.flag = flag;
        this.hoursTranslator = hoursTranslator;
        this.pageTranslator = pageTranslator;
    }

    @Override
    public Translator allow(boolean isAllowed) {
        this.isAllowed = isAllowed;
        return this;
    }

    @Override
    public boolean isAllowed() {
        return isAllowed;
    }

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
    public HomePageTranslatorInterface getPageTranslator() {
        return pageTranslator;
    }

    @Override
    public OpeningHoursTranslatorInterface getHoursTranslator() {
        return hoursTranslator;
    }
}
package eu.bilekpavel.vinotekalara.translator.language.languages;

import eu.bilekpavel.vinotekalara.alertbar.translator.AlertBarTranslator;
import eu.bilekpavel.vinotekalara.app.module.color.translator.CoreColorTranslator;
import eu.bilekpavel.vinotekalara.app.translator.CoreTranslator;
import eu.bilekpavel.vinotekalara.homepage.translator.HomePageTranslator;
import eu.bilekpavel.vinotekalara.openinghours.translator.OpeningHoursTranslator;
import eu.bilekpavel.vinotekalara.superadmin.translator.AdminPageTranslator;
import eu.bilekpavel.vinotekalara.translator.dto.Flag;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import eu.bilekpavel.vinotekalara.translator.internal.Locale;
import eu.bilekpavel.vinotekalara.translator.translator.TranslatorTranslator;
import org.springframework.stereotype.Component;

@Component("germanLocale")
public final class German extends Locale {

    public German(
            CoreTranslator coreTranslator,
            CoreColorTranslator coreColorTranslator,
            TranslatorTranslator translatorTranslator,
            OpeningHoursTranslator hoursTranslator,
            HomePageTranslator pageTranslator,
            AdminPageTranslator adminTranslator,
            AlertBarTranslator alertBarTranslator
    ) {
        super(
                Language.GERMAN,
                new Flag("/images/flags/germany.png", "SELF_NAME"),
                coreTranslator,
                coreColorTranslator,
                translatorTranslator,
                adminTranslator,
                pageTranslator,
                hoursTranslator,
                alertBarTranslator
        );
    }
}
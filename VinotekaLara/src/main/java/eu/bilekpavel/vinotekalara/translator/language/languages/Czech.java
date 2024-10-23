package eu.bilekpavel.vinotekalara.translator.language.languages;

import eu.bilekpavel.vinotekalara.alertbar.translator.AlertBarTranslator;
import eu.bilekpavel.vinotekalara.app.module.color.translator.CoreColorTranslator;
import eu.bilekpavel.vinotekalara.app.translator.CoreTranslator;
import eu.bilekpavel.vinotekalara.homepage.translator.HomePageTranslator;
import eu.bilekpavel.vinotekalara.openinghours.translator.OpeningHoursTranslator;
import eu.bilekpavel.vinotekalara.superadmin.translator.AdminPageTranslator;
import eu.bilekpavel.vinotekalara.translator.dto.Flag;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import eu.bilekpavel.vinotekalara.translator.impl.Locale;
import eu.bilekpavel.vinotekalara.translator.translator.TranslatorTranslator;
import org.springframework.stereotype.Component;

@Component("czechLocale")
public final class Czech extends Locale {

    public Czech(
            CoreTranslator coreTranslator,
            CoreColorTranslator coreColorTranslator,
            TranslatorTranslator translatorTranslator,
            AdminPageTranslator adminTranslator,
            HomePageTranslator pageTranslator,
            OpeningHoursTranslator hoursTranslator,
            AlertBarTranslator alertBarTranslator
    ) {
        super(
                Language.CZECH,
                new Flag("/images/flags/czech.png", "SELF_NAME"),
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
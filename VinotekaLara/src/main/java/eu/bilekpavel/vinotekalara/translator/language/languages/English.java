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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("englishLocale")
public class English extends Locale {

    public English(
            CoreTranslator coreTranslator,
            CoreColorTranslator coreColorTranslator,
            OpeningHoursTranslator hoursTranslator,
            HomePageTranslator pageTranslator,
            AdminPageTranslator adminTranslator,
            AlertBarTranslator alertBarTranslator
    ) {
        super(
                Language.ENGLISH,
                new Flag("/images/flags/uk.png", "SELF_NAME"),
                coreTranslator,
                coreColorTranslator,
                adminTranslator,
                pageTranslator,
                hoursTranslator,
                alertBarTranslator
        );
    }
}
package eu.bilekpavel.vinotekalara.translator.language.languages;

import eu.bilekpavel.vinotekalara.alertbar.translator.AlertBarTranslator;
import eu.bilekpavel.vinotekalara.app.translator.CoreTranslator;
import eu.bilekpavel.vinotekalara.homepage.translator.HomePageTranslator;
import eu.bilekpavel.vinotekalara.openinghours.translator.OpeningHoursTranslator;
import eu.bilekpavel.vinotekalara.superadmin.translator.AdminPageTranslator;
import eu.bilekpavel.vinotekalara.translator.dto.Flag;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import eu.bilekpavel.vinotekalara.translator.impl.Locale;
import org.springframework.stereotype.Component;

@Component("czechLocale")
public class Czech extends Locale {

    public Czech(OpeningHoursTranslator hoursTranslator,
                 HomePageTranslator pageTranslator,
                 AdminPageTranslator adminTranslator,
                 AlertBarTranslator alertBarTranslator,
                 CoreTranslator coreTranslator
    ) {
        super(
                Language.CZECH,
                new Flag("/images/flags/czech.png", "česky"),
                coreTranslator,
                hoursTranslator,
                pageTranslator,
                adminTranslator,
                alertBarTranslator
        );
    }
}
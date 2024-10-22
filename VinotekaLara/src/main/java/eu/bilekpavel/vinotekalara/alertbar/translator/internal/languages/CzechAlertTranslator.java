package eu.bilekpavel.vinotekalara.alertbar.translator.internal.languages;

import eu.bilekpavel.vinotekalara.alertbar.translator.internal.AbstractAlertBarTranslator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("czechAlertTranslator")
public final class CzechAlertTranslator extends AbstractAlertBarTranslator {

    public CzechAlertTranslator() {
        super(
                "lišta upozornění",
                "povolit lištu",
                "zobrazit lištu",
                "vyberte lištu",
                "vytvořit lištu"
        );
    }
}

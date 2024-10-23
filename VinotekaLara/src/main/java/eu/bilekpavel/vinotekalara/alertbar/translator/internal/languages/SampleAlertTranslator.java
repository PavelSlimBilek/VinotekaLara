package eu.bilekpavel.vinotekalara.alertbar.translator.internal.languages;

import eu.bilekpavel.vinotekalara.alertbar.translator.internal.AbstractAlertBarTranslator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public final class SampleAlertTranslator extends AbstractAlertBarTranslator {

    public SampleAlertTranslator() {
        super(
                "ALERT_BAR",
                "ALLOW_ALERT_BAR",
                "DISPLAY_ALERT_BAR",
                "SELECT_ALERT_BAR",
                "CREATE_ALERT_BAR"
        );
    }
}

package eu.bilekpavel.vinotekalara.alertbar.domain;

import eu.bilekpavel.vinotekalara.app.dto.Color;
import eu.bilekpavel.vinotekalara.translator.dto.LocalizedString;

public final class AlertBuilder {

    private final Alert ALERT = new Alert();

    public AlertBuilder addLocalization(LocalizedString request) {
        ALERT.updateLocalization(request);
        return this;
    }

    public AlertBuilder setColor(Color color) {
        ALERT.setBackgroundColor(color);
        return this;
    }

    public Alert build() {
        return ALERT;
    }
}

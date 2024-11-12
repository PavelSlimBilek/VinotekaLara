package eu.bilekpavel.vinotekalara.alertbar.model;

import eu.bilekpavel.vinotekalara.app.module.color.dto.Color;
import eu.bilekpavel.vinotekalara.translator.dto.LocalizedString;

public final class AlertBuilder {

    private final Alert ALERT = new Alert();

    public AlertBuilder addLocalization(LocalizedString request) {
        ALERT.updateContent(request);
        return this;
    }

    public AlertBuilder setBackgroundColor(Color color) {
        ALERT.setBackgroundColor(color);
        return this;
    }

    public AlertBuilder setFontColor(Color color) {
        ALERT.setFontColor(color);
        return this;
    }

    public AlertBuilder setColors(Color background, Color font) {
        ALERT.setBackgroundColor(background);
        ALERT.setFontColor(font);
        return this;
    }

    public Alert build() {
        return ALERT;
    }
}

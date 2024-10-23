package eu.bilekpavel.vinotekalara.alertbar.dto;

import eu.bilekpavel.vinotekalara.alertbar.translator.dto.LocalizedAlert;

import java.util.List;

public record AlertBarWidgetData(
        List<LocalizedAlert> alertBars,
        boolean isAlertBarAllowed,
        boolean isAlertBarDisplayed
) {
}

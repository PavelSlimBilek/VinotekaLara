package eu.bilekpavel.vinotekalara.alertbar.dto;

import java.util.List;

public record AlertBarWidgetData(
        List<LocalizedAlert> alertBars,
        boolean isAlertBarAllowed,
        boolean isAlertBarDisplayed
) {
}

package eu.bilekpavel.vinotekalara.superadmin;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AlertBarConfig {
    private boolean isDisplayed = true;

    public boolean isDisplayed() {
        return isDisplayed;
    }

    public void toggleDisplay() {
        isDisplayed = !isDisplayed;
    }
}
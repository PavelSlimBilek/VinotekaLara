package eu.bilekpavel.vinotekalara.admin;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AlertBarConfig {
    private boolean isDisplayed = false;

    public boolean isDisplayed() {
        return isDisplayed;
    }

    public void toggleDisplay() {
        isDisplayed = !isDisplayed;
    }
}
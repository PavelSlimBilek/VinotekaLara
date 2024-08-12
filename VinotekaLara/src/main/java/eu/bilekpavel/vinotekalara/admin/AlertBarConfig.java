package eu.bilekpavel.vinotekalara.admin;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AlertBarConfig {
    private boolean isAllowed = false;

    public boolean isAllowed() {
        return isAllowed;
    }

    public void setAllowed(boolean allowed) {
        isAllowed = allowed;
    }
}
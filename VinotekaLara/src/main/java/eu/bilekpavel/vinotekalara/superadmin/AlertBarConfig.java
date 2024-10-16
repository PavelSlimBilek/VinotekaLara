package eu.bilekpavel.vinotekalara.superadmin;

import lombok.Getter;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class AlertBarConfig {
    private boolean isAllowed = false;
    private boolean isDisplayed = true;

    public void display(boolean isDisplayed) {
        this.isDisplayed = isDisplayed;
    }

    public void allow(boolean isAllowed) {
        this.isAllowed = isAllowed;
    }
}
package eu.bilekpavel.vinotekalara.openinghours;

import org.springframework.context.annotation.Configuration;

@Configuration
public class WeeklyHoursConfig {

    private boolean areAfternoonHoursAllowed = false;

    public boolean areAfternoonHoursAllowed() {
        return areAfternoonHoursAllowed;
    }

    public void allowAfternoonHours(boolean isAllowed) {
        areAfternoonHoursAllowed = isAllowed;
    }
}

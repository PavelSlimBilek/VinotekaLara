package eu.bilekpavel.vinotekalara.alertbar.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
public class AlertBarConfig {
    private boolean allowed = false;
    private boolean displayed = false;
}
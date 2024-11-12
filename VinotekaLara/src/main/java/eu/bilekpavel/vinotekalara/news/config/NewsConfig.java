package eu.bilekpavel.vinotekalara.news.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
public class NewsConfig {
    private boolean isAllowed;
    private boolean isDisplayed;
}

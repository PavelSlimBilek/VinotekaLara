package eu.bilekpavel.vinotekalara.app;

import eu.bilekpavel.vinotekalara.translator.language.Language;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppSettings {
    public static final String NAME = "Vinotéka Lara";

    public static final Language DEFAULT_LANGUAGE = Language.CZECH;

    public static final boolean areAfternoonHoursAllowed = false;
}
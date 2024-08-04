package eu.bilekpavel.vinotekalara.config;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
public class HomePageContentProvider {

    public static String TITLE = AppSettings.NAME;

    public static final String WELCOME_MESSAGE = "Vítejte!";

    public static void addTo(Model model) {
        model.addAttribute("title", TITLE);
        model.addAttribute("message", WELCOME_MESSAGE);
    }
}
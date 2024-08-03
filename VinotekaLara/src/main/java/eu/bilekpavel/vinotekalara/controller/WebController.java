package eu.bilekpavel.vinotekalara.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("title", "Vinotéka Lara");
        model.addAttribute("greeting", "Vítejte!");
        return "home";
    }
}
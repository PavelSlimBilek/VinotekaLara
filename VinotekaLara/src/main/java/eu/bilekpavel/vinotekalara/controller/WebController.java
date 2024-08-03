package eu.bilekpavel.vinotekalara.controller;

import eu.bilekpavel.vinotekalara.dto.OpeningHoursRequest;
import eu.bilekpavel.vinotekalara.service.OpeningHoursServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.DayOfWeek;

@Controller
@AllArgsConstructor
public class WebController {

    private OpeningHoursServiceInterface hoursService;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("title", "Vinotéka Lara");
        model.addAttribute("greeting", "Vítejte!");
        model.addAttribute("daysOfWeek", DayOfWeek.values());
        model.addAttribute("openingHours", hoursService.getOpeningHours());
        return "home";
    }

    @PostMapping("/opening-hours")
    public String updateHours(@ModelAttribute OpeningHoursRequest hours) {
        try {
            this.hoursService.save(hours);
        } catch (Exception e) {
            return "redirect:/home";
        }
        return "redirect:/home";
    }
}
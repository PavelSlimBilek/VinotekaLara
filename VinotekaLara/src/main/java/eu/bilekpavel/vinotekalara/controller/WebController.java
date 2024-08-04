package eu.bilekpavel.vinotekalara.controller;

import eu.bilekpavel.vinotekalara.config.AppSettings;
import eu.bilekpavel.vinotekalara.config.HomePageContentProvider;
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
        HomePageContentProvider.addTo(model);
        model.addAttribute("daysOfWeek", DayOfWeek.values());
        model.addAttribute("openingHours", hoursService.getTransformedOpeningHours());
        model.addAttribute("todayHours", hoursService.getTransformedTodayHours());
        model.addAttribute("isOpened", hoursService.getOpenedMessage());
        model.addAttribute("areAfternoonHoursAllowed", AppSettings.areAfternoonHoursAllowed);
        return "home";
    }

    @PostMapping("/opening-hours")
    public String updateHours(@ModelAttribute OpeningHoursRequest hours) {
        try {
            this.hoursService.save(hours);
        } catch (Exception e) {
            return "redirect:/home";
        }
        this.hoursService.updateHours();
        return "redirect:/home";
    }
}
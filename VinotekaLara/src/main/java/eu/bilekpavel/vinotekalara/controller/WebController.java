package eu.bilekpavel.vinotekalara.controller;

import eu.bilekpavel.vinotekalara.config.AppSettings;
import eu.bilekpavel.vinotekalara.config.HomePageContentProvider;
import eu.bilekpavel.vinotekalara.openinghours.dto.OpeningHoursRequest;
import eu.bilekpavel.vinotekalara.openinghours.service.OpeningHoursServiceInterface;
import eu.bilekpavel.vinotekalara.translator.TranslatorInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.DayOfWeek;

@Controller
public class WebController {

    private final OpeningHoursServiceInterface hoursService;

    private final TranslatorInterface czechTransformer;
    private final TranslatorInterface englishTransformer;

    public WebController(OpeningHoursServiceInterface hoursService,
                         @Qualifier("czechTransformer") TranslatorInterface czechTransformer,
                         @Qualifier("englishTransformer") TranslatorInterface englishTransformer) {

        this.hoursService = hoursService;
        this.czechTransformer = czechTransformer;
        this.englishTransformer = englishTransformer;
    }

    @GetMapping("/home")
    public String home(Model model, @RequestParam(name = "lang", required = false) String lang) {
        TranslatorInterface transformer = (lang != null && lang.equalsIgnoreCase("en"))
                ? englishTransformer
                : czechTransformer;

        model.addAttribute("daysOfWeek", DayOfWeek.values());
        model.addAttribute("openingHours", hoursService.getTransformedOpeningHours(transformer));
        model.addAttribute("todayHours", hoursService.getTransformedTodayHours(transformer));
        model.addAttribute("isOpened", hoursService.getOpenedMessage(transformer));
        model.addAttribute("areAfternoonHoursAllowed", AppSettings.areAfternoonHoursAllowed);

        HomePageContentProvider.addTo(model);

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
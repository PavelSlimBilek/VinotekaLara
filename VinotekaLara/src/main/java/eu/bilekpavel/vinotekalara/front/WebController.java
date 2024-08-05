package eu.bilekpavel.vinotekalara.front;

import eu.bilekpavel.vinotekalara.app.AppSettings;
import eu.bilekpavel.vinotekalara.openinghours.dto.OpeningHoursRequest;
import eu.bilekpavel.vinotekalara.openinghours.service.OpeningHoursServiceInterface;
import eu.bilekpavel.vinotekalara.openinghours.translator.OpeningHoursTranslatorInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

    private final OpeningHoursServiceInterface hoursService;

    private final OpeningHoursTranslatorInterface czechTranslator;
    private final OpeningHoursTranslatorInterface englishTranslator;

    public WebController(OpeningHoursServiceInterface hoursService,
                         @Qualifier("czechTransformer") OpeningHoursTranslatorInterface czechTranslator,
                         @Qualifier("englishTransformer") OpeningHoursTranslatorInterface englishTranslator) {

        this.hoursService = hoursService;
        this.czechTranslator = czechTranslator;
        this.englishTranslator = englishTranslator;
    }

    @GetMapping("/home")
    public String home(Model model,
                       @RequestParam(name = "lang", required = false, defaultValue = "cs") String lang) {

        lang = lang.equals("en") ? "en" : "cs";
        OpeningHoursTranslatorInterface translator = lang.equals("en")
                ? englishTranslator
                : czechTranslator;

        model.addAttribute("_lang", lang);
        model.addAttribute("_title", AppSettings.NAME);
        model.addAttribute("_message", lang.equals("cs") ? "Vítejte!" : "Welcome!");
        model.addAttribute("_submit", lang.equals("cs") ? "Odeslat!" : "Submit!");
        model.addAttribute("_day", translator.getDay());
        model.addAttribute("_start", translator.getStart());
        model.addAttribute("_end", translator.getEnd());
        model.addAttribute("_morningHours", translator.getMorningHours());
        model.addAttribute("_afternoonHours", translator.getAfternoonHours());
        model.addAttribute("_openingHoursTranslation", translator.getOpeningHours());
        model.addAttribute("_daysOfWeek", hoursService.getTranslatedDaysOfWeek(translator));
        model.addAttribute("_openingHours", hoursService.getTranslatedOpeningHours(translator));
        model.addAttribute("_todayHours", hoursService.getTranslatedTodayHours(translator));
        model.addAttribute("_isOpened", hoursService.getTranslatedOpenedMessage(translator));
        model.addAttribute("_areAfternoonHoursAllowed", AppSettings.areAfternoonHoursAllowed);

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
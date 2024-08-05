package eu.bilekpavel.vinotekalara.front;

import eu.bilekpavel.vinotekalara.app.AppSettings;
import eu.bilekpavel.vinotekalara.front.translator.HomePageTranslatorInterface;
import eu.bilekpavel.vinotekalara.openinghours.dto.OpeningHoursRequest;
import eu.bilekpavel.vinotekalara.openinghours.service.OpeningHoursServiceInterface;
import eu.bilekpavel.vinotekalara.openinghours.translator.OpeningHoursTranslatorInterface;
import eu.bilekpavel.vinotekalara.translator.Language;
import eu.bilekpavel.vinotekalara.translator.LanguageMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class WebController {

    private final Language defaultLanguage = Language.CZECH;

    private final OpeningHoursServiceInterface hoursService;
    private final HomePageContentProviderInterface service;

    private final Map<Language, OpeningHoursTranslatorInterface> hoursTranslators = new HashMap<>();
    private final Map<Language, HomePageTranslatorInterface> homePageTranslators = new HashMap<>();

    public WebController(OpeningHoursServiceInterface hoursService,
                         HomePageContentProviderInterface service,
                         @Qualifier("czech") OpeningHoursTranslatorInterface czechTranslator,
                         @Qualifier("english") OpeningHoursTranslatorInterface englishTranslator,
                         @Qualifier("german") OpeningHoursTranslatorInterface germanTranslator,

                         @Qualifier("czech") HomePageTranslatorInterface czechPageTranslator,
                         @Qualifier("english") HomePageTranslatorInterface englishPageTranslator,
                         @Qualifier("german") HomePageTranslatorInterface germanPageTranslator
    ) {

        this.hoursService = hoursService;
        this.service = service;
        hoursTranslators.put(Language.CZECH, czechTranslator);
        hoursTranslators.put(Language.ENGLISH, englishTranslator);
        hoursTranslators.put(Language.GERMAN, germanTranslator);

        homePageTranslators.put(Language.CZECH, czechPageTranslator);
        homePageTranslators.put(Language.ENGLISH, englishPageTranslator);
        homePageTranslators.put(Language.GERMAN, germanPageTranslator);
    }

    @GetMapping("/home")
    public String home(Model model,
                       @RequestParam(name = "lang", required = false, defaultValue = "cs") String lang) {

        OpeningHoursTranslatorInterface translator = LanguageMapper.isOnList(lang)
                ? hoursTranslators.get(LanguageMapper.getLanguage(lang))
                : hoursTranslators.get(defaultLanguage);

        HomePageTranslatorInterface pageTranslator = LanguageMapper.isOnList(lang)
                ? homePageTranslators.get(LanguageMapper.getLanguage(lang))
                : homePageTranslators.get(defaultLanguage);

        model.addAttribute("_pageContent", service.getTranslatedContent(pageTranslator));

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
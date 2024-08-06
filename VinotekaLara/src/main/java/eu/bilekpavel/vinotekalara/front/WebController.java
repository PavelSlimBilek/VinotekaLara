package eu.bilekpavel.vinotekalara.front;

import eu.bilekpavel.vinotekalara.alertbar.service.AlertBarServiceInterface;
import eu.bilekpavel.vinotekalara.app.AppSettings;
import eu.bilekpavel.vinotekalara.front.translator.HomePageTranslatorInterface;
import eu.bilekpavel.vinotekalara.openinghours.dto.OpeningHoursRequest;
import eu.bilekpavel.vinotekalara.openinghours.service.OpeningHoursServiceInterface;
import eu.bilekpavel.vinotekalara.openinghours.translator.OpeningHoursTranslatorInterface;
import eu.bilekpavel.vinotekalara.translator.dto.Language;
import eu.bilekpavel.vinotekalara.translator.LanguageMapper;
import eu.bilekpavel.vinotekalara.translator.service.LocalizationService;
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

    private final HomePageContentProviderInterface pageContentProvider;
    private final LocalizationService localizationService;
    private final AlertBarServiceInterface alertBarService;

    private final OpeningHoursServiceInterface hoursService;

    private final Map<Language, OpeningHoursTranslatorInterface> hoursTranslators = new HashMap<>();
    private final Map<Language, HomePageTranslatorInterface> homePageTranslators = new HashMap<>();

    public WebController(OpeningHoursServiceInterface hoursService,
                         LocalizationService localizationService,
                         HomePageContentProviderInterface pageContentProvider,
                         AlertBarServiceInterface alertBarService,
                         @Qualifier("czech") OpeningHoursTranslatorInterface czechTranslator,
                         @Qualifier("english") OpeningHoursTranslatorInterface englishTranslator,
                         @Qualifier("german") OpeningHoursTranslatorInterface germanTranslator,

                         @Qualifier("czech") HomePageTranslatorInterface czechPageTranslator,
                         @Qualifier("english") HomePageTranslatorInterface englishPageTranslator,
                         @Qualifier("german") HomePageTranslatorInterface germanPageTranslator
    ) {

        this.hoursService = hoursService;
        this.pageContentProvider = pageContentProvider;
        this.localizationService = localizationService;
        this.alertBarService = alertBarService;

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

        boolean isOnList = LanguageMapper.isOnList(lang);

        OpeningHoursTranslatorInterface hoursTranslator = isOnList
                ? hoursTranslators.get(LanguageMapper.getLanguage(lang))
                : hoursTranslators.get(defaultLanguage);

        HomePageTranslatorInterface pageTranslator = isOnList
                ? homePageTranslators.get(LanguageMapper.getLanguage(lang))
                : homePageTranslators.get(defaultLanguage);

        model.addAttribute("_pageContent", pageContentProvider.getTranslatedContent(pageTranslator));
        model.addAttribute("_localizationWidget", localizationService.getAll());

        model.addAttribute("_alertBar", alertBarService.getAll(pageTranslator.getLanguage()).getFirst());

        model.addAttribute("_areAfternoonHoursAllowed", AppSettings.areAfternoonHoursAllowed);
        model.addAttribute("_hoursWidget", hoursService.getTranslatedData(hoursTranslator));

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
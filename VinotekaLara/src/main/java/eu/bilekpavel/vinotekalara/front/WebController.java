package eu.bilekpavel.vinotekalara.front;

import eu.bilekpavel.vinotekalara.alertbar.service.AlertBarServiceInterface;
import eu.bilekpavel.vinotekalara.app.AppSettings;
import eu.bilekpavel.vinotekalara.openinghours.dto.OpeningHoursRequest;
import eu.bilekpavel.vinotekalara.openinghours.service.OpeningHoursServiceInterface;
import eu.bilekpavel.vinotekalara.translator.Translator;
import eu.bilekpavel.vinotekalara.translator.TranslatorRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

    private final HomePageContentProviderInterface pageContentProvider;
    private final TranslatorRegistry localizations;

    private final OpeningHoursServiceInterface hoursService;
    private final AlertBarServiceInterface alertBarService;

    public WebController(HomePageContentProviderInterface pageContentProvider,
                         TranslatorRegistry localizations,
                         OpeningHoursServiceInterface hoursService,
                         AlertBarServiceInterface alertBarService

    ) {
        this.pageContentProvider = pageContentProvider;
        this.localizations = localizations;

        this.hoursService = hoursService;
        this.alertBarService = alertBarService;
    }

    @GetMapping("/home")
    public String home(Model model,
                       @RequestParam(name = "lang", required = false, defaultValue = "cs") String lang) {

        Translator translator = this.localizations.getLocale(lang);

        model.addAttribute("_pageContent", pageContentProvider.getTranslatedContent(translator.getPageTranslator()));
        model.addAttribute("_localizationWidget", localizations.getData(translator));

        model.addAttribute("_alertBar", alertBarService.getAll(translator.getLang()).getFirst());

        model.addAttribute("_areAfternoonHoursAllowed", AppSettings.areAfternoonHoursAllowed);
        model.addAttribute("_hoursWidget", hoursService.getTranslatedData(translator.getHoursTranslator()));

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
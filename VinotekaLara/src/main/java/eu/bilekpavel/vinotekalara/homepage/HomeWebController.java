package eu.bilekpavel.vinotekalara.homepage;

import eu.bilekpavel.vinotekalara.alertbar.service.AlertBarServiceInterface;
import eu.bilekpavel.vinotekalara.app.AppSettings;
import eu.bilekpavel.vinotekalara.openinghours.service.OpeningHoursServiceInterface;
import eu.bilekpavel.vinotekalara.translator.Translator;
import eu.bilekpavel.vinotekalara.translator.TranslatorRegistry;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class HomeWebController {

    private final HomePageContentProviderInterface pageContentProvider;
    private final TranslatorRegistry localizations;

    private final OpeningHoursServiceInterface hoursService;
    private final AlertBarServiceInterface alertBarService;

    @GetMapping("/home")
    public String home(Model model,
                       HttpServletRequest request,
                       @RequestParam(name = "lang", required = false, defaultValue = "cs") String lang) {

        Translator translator = this.localizations.getLocale(lang);

        model.addAttribute("_requestURI", request.getRequestURI());
        model.addAttribute("_pageContent", pageContentProvider.getTranslatedContent(translator.getPageTranslator()));
        model.addAttribute("_localizationWidget", localizations.getData(translator));

        model.addAttribute("_alertBar", alertBarService.getAllTranslated(translator.getLang()).getFirst());

        model.addAttribute("_areAfternoonHoursAllowed", AppSettings.areAfternoonHoursAllowed);
        model.addAttribute("_hoursWidget", hoursService.getTranslatedData(translator.getHoursTranslator()));

        return "home";
    }
}
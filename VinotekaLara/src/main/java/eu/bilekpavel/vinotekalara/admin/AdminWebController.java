package eu.bilekpavel.vinotekalara.admin;

import eu.bilekpavel.vinotekalara.alertbar.dto.Color;
import eu.bilekpavel.vinotekalara.alertbar.service.AlertBarServiceInterface;
import eu.bilekpavel.vinotekalara.openinghours.dto.OpeningHoursRequest;
import eu.bilekpavel.vinotekalara.openinghours.service.OpeningHoursServiceInterface;
import eu.bilekpavel.vinotekalara.translator.Translator;
import eu.bilekpavel.vinotekalara.translator.TranslatorRegistry;

import eu.bilekpavel.vinotekalara.translator.language.Language;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminWebController {

    private final AdminContentProviderInterface pageContentProvider;
    private final TranslatorRegistry localizations;

    private final OpeningHoursServiceInterface hoursService;

    private final AlertBarServiceInterface alertBarService;
    private final AlertBarConfig alertBarConfig;

    @GetMapping()
    public String admin(Model model,
                        HttpServletRequest request,
                        @RequestParam(name = "lang", required = false, defaultValue = "cs") String lang
    ) {
        Translator translator = this.localizations.getLocale(lang);

        model.addAttribute("_requestURI", request.getRequestURI());
        model.addAttribute("_localizationWidget", localizations.getData(translator));
        model.addAttribute("_hoursWidget", hoursService.getTranslatedData(translator.getHoursTranslator()));
        model.addAttribute("_isAlertBarAllowed", alertBarConfig.isAllowed());
        return "admin";
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

    @PostMapping("/alert-bar/color")
    public String updateAlertBarColor(Color color) {
        alertBarService.updateColor(color);
        return "redirect:/admin";
    }

    @PostMapping("/alert-bar/{lang}")
    public String updateTranslatedAlerts(@PathVariable String lang, String content) {
        if (this.localizations.isOnTheList(lang)) {
            Language language = localizations.getLocale(lang).getLang();
            alertBarService.updateContent(language, content);
        }
        return "redirect:/admin";
    }

    @PostMapping("/alert-bar/allow")
    public String toggleAlertBar(@ModelAttribute Allow allow) {
        alertBarConfig.setAllowed(allow.isAllowed());
        return "redirect:/admin";
    }
}
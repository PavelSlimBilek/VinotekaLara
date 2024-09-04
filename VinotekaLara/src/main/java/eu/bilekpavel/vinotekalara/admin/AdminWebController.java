package eu.bilekpavel.vinotekalara.admin;

import eu.bilekpavel.vinotekalara.app.Color;
import eu.bilekpavel.vinotekalara.alertbar.service.AlertBarServiceInterface;
import eu.bilekpavel.vinotekalara.openinghours.dto.OpeningHoursRequest;
import eu.bilekpavel.vinotekalara.openinghours.service.OpeningHoursServiceInterface;
import eu.bilekpavel.vinotekalara.translator.api.Translator;
import eu.bilekpavel.vinotekalara.translator.api.TranslatorDataFactoryInterface;
import eu.bilekpavel.vinotekalara.translator.impl.TranslatorRegistry;

import eu.bilekpavel.vinotekalara.translator.dto.LocalizedStringRequest;
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
    private final TranslatorDataFactoryInterface translatorDataProvider;

    private final OpeningHoursServiceInterface hoursService;

    private final AlertBarServiceInterface alertBarService;
    private final AlertBarConfig alertBarConfig;

    @GetMapping
    public String admin(Model model,
                        HttpServletRequest request,
                        @RequestParam(name = "lang", required = false, defaultValue = "cs") String lang
    ) {
        Translator translator = this.localizations.getLocale(lang);

        model.addAttribute("_requestURI", request.getRequestURI());
        model.addAttribute("_localizationWidget", translatorDataProvider.create(translator));
        model.addAttribute("_hoursWidget", hoursService.getTranslatedData(translator.getHoursTranslator()));
        model.addAttribute("_isAlertBarAllowed", alertBarConfig.isDisplayed());
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

    @PostMapping("/alert-bar/{id}/color")
    public String updateColor(@PathVariable int id, Color color) {
        alertBarService.updateColor(id, color);
        return "redirect:/admin";
    }

    @PostMapping("/alert-bar/{id}")
    public String updateTranslation(@PathVariable int id, LocalizedStringRequest request) {
        if (this.localizations.isOnTheList(request.langCode())) {
            alertBarService.updateLocalization(id, request);
        }
        return "redirect:/admin";
    }

    @PostMapping("/alert-bar/toggle")
    public String toggleAlertBar() {
        alertBarConfig.toggleDisplay();
        return "redirect:/admin";
    }
}
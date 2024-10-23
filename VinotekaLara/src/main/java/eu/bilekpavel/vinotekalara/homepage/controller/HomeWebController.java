package eu.bilekpavel.vinotekalara.homepage.controller;

import eu.bilekpavel.vinotekalara.app.config.AppConfig;
import eu.bilekpavel.vinotekalara.homepage.translator.HomePageTranslatorDataFactoryInterface;
import eu.bilekpavel.vinotekalara.openinghours.service.WeeklyHoursServiceInterface;
import eu.bilekpavel.vinotekalara.alertbar.config.AlertBarConfig;
import eu.bilekpavel.vinotekalara.alertbar.service.AlertBarServiceInterface;
import eu.bilekpavel.vinotekalara.translator.api.Translator;
import eu.bilekpavel.vinotekalara.translator.impl.TranslatorWidgetDataFactory;
import eu.bilekpavel.vinotekalara.translator.impl.TranslatorRegistry;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class HomeWebController {

    private final AppConfig config;

    private final HomePageTranslatorDataFactoryInterface pageLocalizationProvider;
    private final TranslatorRegistry localizations;
    private final TranslatorWidgetDataFactory translatorDataProvider;

    private final WeeklyHoursServiceInterface hoursService;
    private final AlertBarServiceInterface alertBarService;
    private final AlertBarConfig alertBarConfig;

    @GetMapping("/home")
    public String home(Model model,
                       HttpServletRequest request,
                       @RequestParam(name = "lang", required = false, defaultValue = "cs") String lang) {

        Translator locale = lang == null || lang.isEmpty() || !localizations.isOnTheList(lang) ||  !config.isAllowed(lang)
                ? this.localizations.getLocale(config.getDEFAULT().getCode())
                : this.localizations.getLocale(lang);

        model.addAttribute("_requestURI", request.getRequestURI());
        model.addAttribute("_homePageLocalization", pageLocalizationProvider.create(locale.homePageTranslator()));
        model.addAttribute("_localizationWidget", translatorDataProvider.create(locale));

        model.addAttribute("_isAlertBarDisplayed", alertBarConfig.isDisplayed());
        model.addAttribute("_isAlertBarAllowed", alertBarConfig.isAllowed());
        model.addAttribute("_alertBar", alertBarService.getActive(locale.getLang()));

        model.addAttribute("_hoursWidget", hoursService.getTranslatedData(locale.hoursTranslator()));

        return "home";
    }
}
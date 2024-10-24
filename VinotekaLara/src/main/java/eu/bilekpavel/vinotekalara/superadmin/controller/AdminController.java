package eu.bilekpavel.vinotekalara.superadmin.controller;

import eu.bilekpavel.vinotekalara.alertbar.translator.AlertBarTranslatorDataFactoryInterface;
import eu.bilekpavel.vinotekalara.app.config.AppConfig;
import eu.bilekpavel.vinotekalara.app.translator.CoreTranslatorDataFactoryInterface;
import eu.bilekpavel.vinotekalara.openinghours.translator.OpeningHoursTranslatorDataFactoryInterface;
import eu.bilekpavel.vinotekalara.superadmin.translator.AdminPageTranslatorDataFactoryInterface;
import eu.bilekpavel.vinotekalara.translator.api.Translator;
import eu.bilekpavel.vinotekalara.translator.internal.TranslatorRegistry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@AllArgsConstructor
public final class AdminController {

    private final TranslatorRegistry locales;

    private final AdminPageTranslatorDataFactoryInterface adminLocalizationDataProvider;
    private final AlertBarTranslatorDataFactoryInterface alertLocalizationDataProvider;
    private final OpeningHoursTranslatorDataFactoryInterface hoursLocalizationDataProvider;
    private final CoreTranslatorDataFactoryInterface coreLocalizationProvider;

    private final AppConfig config;

    @GetMapping("/super-admin")
    public String baseView(
            Model model,
            @RequestParam(required = false) String lang,
            RedirectAttributes attributes
    ) {
        Translator locale = lang == null || lang.isEmpty() || !locales.isOnTheList(lang)
                ? locales.getLocale(config.getDEFAULT().getCode())
                : locales.getLocale(lang);

        model.addAttribute("_adminLocalization", adminLocalizationDataProvider.create(locale.getAdminTranslator()));
        model.addAttribute("_alertLocalization", alertLocalizationDataProvider.create(locale.alertTranslator()));
        model.addAttribute("_hoursLocalization", hoursLocalizationDataProvider.create(locale.hoursTranslator()));
        model.addAttribute("_coreLocalization", coreLocalizationProvider.create(locale.coreTranslator()));
        attributes.addAttribute("lang", lang);
        return "/admin/index";
    }
}

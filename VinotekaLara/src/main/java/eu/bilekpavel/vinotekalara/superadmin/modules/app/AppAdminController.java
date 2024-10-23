package eu.bilekpavel.vinotekalara.superadmin.modules.app;

import eu.bilekpavel.vinotekalara.app.config.AppConfig;
import eu.bilekpavel.vinotekalara.app.translator.CoreTranslatorDataFactoryInterface;
import eu.bilekpavel.vinotekalara.app.service.AppServiceInterface;
import eu.bilekpavel.vinotekalara.superadmin.controller.SuperAdminController;
import eu.bilekpavel.vinotekalara.translator.api.Translator;
import eu.bilekpavel.vinotekalara.translator.impl.TranslatorRegistry;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AppAdminController extends SuperAdminController{
    private final AppServiceInterface SERVICE;
    private final AppConfig CONFIG;
    private final CoreTranslatorDataFactoryInterface coreLocalizationProvider;

    public AppAdminController(
            TranslatorRegistry LOCALES,
            AppServiceInterface service,
            AppConfig config,
            CoreTranslatorDataFactoryInterface coreLocalizationProvider
    ) {
        super(LOCALES);
        this.SERVICE = service;
        this.CONFIG = config;
        this.coreLocalizationProvider = coreLocalizationProvider;
    }

    @GetMapping("/app")
    public String app(
            Model model,
            @RequestParam(required = false) String message,
            @RequestParam(required = false) String lang
    ) {
        Translator locale = lang == null || lang.isEmpty() || !LOCALES.isOnTheList(lang)
                ? LOCALES.getLocale(CONFIG.getDEFAULT().getCode())
                : LOCALES.getLocale(lang);

        model.addAttribute("_localizationWidget", SERVICE.getLanguageWidgetData());
        model.addAttribute("_coreLocalization", coreLocalizationProvider.create(locale.coreTranslator()));
        model.addAttribute("_message", message == null ? "" : message);

        return "/admin/app/index";
    }

    @PostMapping("/app/default-language")
    public String setLang(@RequestParam String code) {
        Language lang = LOCALES.getLocale(code).getLang();
        SERVICE.setDefaultLanguage(lang);

        return "redirect:/super-admin/app";
    }

    @PostMapping("/app/language/{name}/toggle")
    public String toggleLanguage(
            @PathVariable String name,
            RedirectAttributes attributes
    ) {
        Language lang = Language.valueOf(name);
        try {
            SERVICE.toggleLanguage(lang);
            attributes.addAttribute("message", String.format("[%s] - %s was updated", lang.getCode(), lang.getSelfName()));
        } catch (RuntimeException e) {
            attributes.addAttribute("message", e.getMessage());
        }
            return "redirect:/super-admin/app";
    }
}

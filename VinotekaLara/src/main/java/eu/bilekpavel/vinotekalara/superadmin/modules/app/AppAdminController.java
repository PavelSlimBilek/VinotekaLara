package eu.bilekpavel.vinotekalara.superadmin.modules.app;

import eu.bilekpavel.vinotekalara.app.config.AppConfig;
import eu.bilekpavel.vinotekalara.app.service.AppServiceInterface;
import eu.bilekpavel.vinotekalara.superadmin.AdminPageContentProviderInterface;
import eu.bilekpavel.vinotekalara.superadmin.SuperAdminController;
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

    public AppAdminController(
            TranslatorRegistry LOCALES,
            AdminPageContentProviderInterface CONTENT_PROVIDER,
            AppServiceInterface service, AppConfig config
    ) {
        super(LOCALES, CONTENT_PROVIDER);
        this.SERVICE = service;
        this.CONFIG = config;
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
        model.addAttribute("_locale", CONTENT_PROVIDER.getLocalizedAdminPage(locale.getAdminTranslator()));
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

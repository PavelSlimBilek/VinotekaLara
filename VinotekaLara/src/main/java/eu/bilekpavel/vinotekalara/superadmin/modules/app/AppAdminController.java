package eu.bilekpavel.vinotekalara.superadmin.modules.app;

import eu.bilekpavel.vinotekalara.app.service.AppServiceInterface;
import eu.bilekpavel.vinotekalara.superadmin.SuperAdminController;
import eu.bilekpavel.vinotekalara.translator.impl.TranslatorRegistry;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AppAdminController extends SuperAdminController{
    private final AppServiceInterface service;

    public AppAdminController(
            TranslatorRegistry LOCALES,
            AppServiceInterface service
    ) {
        super(LOCALES);
        this.service = service;
    }

    @GetMapping("/app")
    public String app(
            Model model,
            @RequestParam(required = false) String message
    ) {
        model.addAttribute("_localizationWidget", service.getLanguageWidgetData());
        model.addAttribute("_message", message == null ? "" : message);

        return "/admin/app/index";
    }

    @PostMapping("/app/default-language")
    public String setLang(@RequestParam String code) {
        Language lang = LOCALES.getLocale(code).getLang();
        service.setDefaultLanguage(lang);

        return "redirect:/super-admin/app";
    }

    @PostMapping("/app/language/{name}/toggle")
    public String toggleLanguage(
            @PathVariable String name,
            RedirectAttributes attributes
    ) {
        Language lang = Language.valueOf(name);
        try {
            service.toggleLanguage(lang);
            attributes.addAttribute("message", String.format("[%s] - %s was updated", lang.getCode(), lang.getSelfName()));
        } catch (RuntimeException e) {
            attributes.addAttribute("message", e.getMessage());
        }
            return "redirect:/super-admin/app";
    }
}

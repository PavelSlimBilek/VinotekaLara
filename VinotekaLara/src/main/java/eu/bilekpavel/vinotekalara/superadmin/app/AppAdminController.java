package eu.bilekpavel.vinotekalara.superadmin.app;

import eu.bilekpavel.vinotekalara.app.service.AppServiceInterface;
import eu.bilekpavel.vinotekalara.superadmin.SuperAdminController;
import eu.bilekpavel.vinotekalara.translator.impl.TranslatorRegistry;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String app(Model model) {
        model.addAttribute("_languageWidget", service.getLanguageWidgetData());
        return "/admin/app/index";
    }

    @PostMapping("/app/default-language")
    public String setLang(@RequestParam String code) {
        Language lang = LOCALES.getLocale(code).getLang();
        System.out.println(lang.getCode() + " " + lang.getSelfName());
        service.setDefaultLanguage(lang);
        return "redirect:/super-admin/app";
    }
}

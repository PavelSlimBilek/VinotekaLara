package eu.bilekpavel.vinotekalara.superadmin.modules.app.translator;

import eu.bilekpavel.vinotekalara.app.translator.CoreTranslatorDataFactoryInterface;
import eu.bilekpavel.vinotekalara.translator.error.CannotForbidDefaultLanguageTranslatorException;
import eu.bilekpavel.vinotekalara.translator.service.TranslatorServiceInterface;
import eu.bilekpavel.vinotekalara.superadmin.controller.SuperAdminController;
import eu.bilekpavel.vinotekalara.translator.api.Translator;
import eu.bilekpavel.vinotekalara.translator.translator.TranslatorTranslatorDataFactoryInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@AllArgsConstructor
public final class TranslatorAdminController extends SuperAdminController{
    private final TranslatorServiceInterface service;

    private final CoreTranslatorDataFactoryInterface coreLocalizationProvider;
    private final TranslatorTranslatorDataFactoryInterface translatorLocalizationProvider;

    @GetMapping("/translator")
    public String app(
            Model model,
            @RequestParam(required = false) String message,
            @RequestParam(required = false) String lang
    ) {
        Translator locale = service.getLocale(lang);
        model.addAttribute("_coreLocalization", coreLocalizationProvider.create(locale.coreTranslator()));
        model.addAttribute("_translatorLocalization", translatorLocalizationProvider.create(locale.translatorTranslator()));

        model.addAttribute("_translatorWidget", service.getTranslatorWidgetData(locale));
        model.addAttribute("_message", message == null ? "TRANSLATOR_SETTINGS" : message);

        return "admin/app/translator/index";
    }

    @PostMapping("/translator/default-language")
    public String setLang(
            @RequestParam String langCode,
            RedirectAttributes attributes
    ) {
        Translator locale = service.getLocale(langCode);
        service.setDefaultTranslator(locale.getLang());

        attributes.addAttribute("message", "Set default language to " + locale.getLang().getSelfName());
        return "redirect:/super-admin/translator";
    }

    @PostMapping("/translator/{langCode}/toggle")
    public String toggleLanguage(
            @PathVariable String langCode,
            RedirectAttributes attributes
    ) {
        final String redirect = "redirect:/super-admin/translator";
        try {
            Translator locale = service.toggleTranslator(langCode);
            attributes.addAttribute(
                    "message",
                    String.format("[%s] - %s was updated",
                            locale.getCode(),
                            locale.getLang().getSelfName())
            );
        } catch (CannotForbidDefaultLanguageTranslatorException e) {
            attributes.addAttribute("message", e.getMessage());
        }
        return redirect;
    }
}

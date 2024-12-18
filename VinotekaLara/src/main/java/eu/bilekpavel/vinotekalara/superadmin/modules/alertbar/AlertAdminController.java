package eu.bilekpavel.vinotekalara.superadmin.modules.alertbar;

import eu.bilekpavel.vinotekalara.alertbar.dto.AlertRequest;
import eu.bilekpavel.vinotekalara.alertbar.service.AlertServiceInterface;
import eu.bilekpavel.vinotekalara.app.module.color.translator.CoreColorTranslatorDataFactoryInterface;
import eu.bilekpavel.vinotekalara.app.translator.CoreTranslatorDataFactoryInterface;
import eu.bilekpavel.vinotekalara.app.dto.Allow;
import eu.bilekpavel.vinotekalara.app.module.color.dto.Color;
import eu.bilekpavel.vinotekalara.translator.service.TranslatorServiceInterface;
import eu.bilekpavel.vinotekalara.superadmin.controller.SuperAdminController;
import eu.bilekpavel.vinotekalara.translator.api.Translator;
import eu.bilekpavel.vinotekalara.translator.dto.LocalizedStringRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@AllArgsConstructor
public final class AlertAdminController extends SuperAdminController {
    private final AlertServiceInterface service;
    private final TranslatorServiceInterface translatorService;

    private final CoreTranslatorDataFactoryInterface coreLocalizationProvider;
    private final CoreColorTranslatorDataFactoryInterface coreColorLocalizationProvider;

    @GetMapping("/alert")
    public String alertAdmin(Model model,
                             @RequestParam(name = "lang", required = false, defaultValue = "cs") String lang,
                             @RequestParam(name = "message", required = false) String message
    ) {
        Translator locale = translatorService.getLocale(lang);

        model.addAttribute("_alertWidget", service.getWidgetData(locale.getLang()));

        model.addAttribute("_coreLocalization", coreLocalizationProvider.create(locale.coreTranslator()));
        model.addAttribute("_alertLocalization", service.getTranslatorData(locale.alertTranslator()));

        model.addAttribute("_message", message == null ? "" : message);
        return "admin/alert-bar/index";
    }

    @GetMapping("/alert/{id}")
    public String viewAlert(Model model,
                            @PathVariable int id,
                            @RequestParam(name = "lang", required = false, defaultValue = "cs") String lang) {

        Translator locale = translatorService.getLocale(lang);

        model.addAttribute("_alertBar", service.get(id));

        model.addAttribute("_localizationWidget", translatorService.getTranslatorWidgetData(locale));
        model.addAttribute("_translatorLocalization", translatorService.getTranslatorTranslatorData(locale.translatorTranslator()));

        model.addAttribute("_coreLocalization", coreLocalizationProvider.create(locale.coreTranslator()));
        model.addAttribute("_coreColorLocalization", coreColorLocalizationProvider.create(locale.coreColorTranslator()));
        model.addAttribute("_alertLocalization", service.getTranslatorData(locale.alertTranslator()));
        return "admin/alert-bar/detail";
    }

    @PostMapping("/alert/allow")
    public String allowAlert(Allow request) {
        boolean isAllowed = request.isAllowed();
        service.allow(isAllowed);
        return "redirect:/super-admin/alert";
    }

    @PostMapping("/alert/display")
    public String displayAlert(Allow request) {
        boolean isAllowed = request.isAllowed();
        service.display(isAllowed);
        return "redirect:/super-admin/alert";
    }

    @PostMapping("/alert/{id}/background-color")
    public String updateColor(
            @PathVariable int id,
            Color color
    ) {
        service.updateBackgroundColor(id, color);
        return "redirect:/super-admin/alert/" + id;
    }

    @PostMapping("/alert/{id}/font-color")
    public String updateFontColor(
            @PathVariable int id,
            Color color
    ) {
        service.updateFontColor(id, color);
        return "redirect:/super-admin/alert/" + id;
    }

    @PostMapping("/alert/{id}")
    public String updateLocalization(
            @PathVariable int id,
            LocalizedStringRequest request
    ) {
        service.updateLocalization(id, request);
        return "redirect:/super-admin/alert/" + id;
    }

    @PostMapping("/alert/activate/{id}")
    public String activate(
            @PathVariable int id
    ) {
        service.setActive(id);
        return "redirect:/super-admin/alert";
    }

    @PostMapping("/alert/{id}/delete")
    public String delete(
            @PathVariable int id,
            RedirectAttributes attributes
    ) {
        try {
            service.delete(id);
        } catch (RuntimeException e) {
            attributes.addAttribute("message", e.getMessage());
        }
        return "redirect:/super-admin/alert";
    }

    @PostMapping("/alert/create")
    public String create(
            RedirectAttributes attributes
    ) {
        service.create(
                new AlertRequest(List.of(
                        new LocalizedStringRequest("Základní text", "cz"),
                        new LocalizedStringRequest("Base text", "en"),
                        new LocalizedStringRequest("Basistext", "de"),
                        new LocalizedStringRequest("Основний текст", "uk"),
                        new LocalizedStringRequest("Texte de base", "fr")
                ),
                        "#FFF")
        );
        attributes.addAttribute("message", "Successfully created");
        return "redirect:/super-admin/alert";
    }
}

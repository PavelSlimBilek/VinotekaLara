package eu.bilekpavel.vinotekalara.superadmin.modules.alertbar;

import eu.bilekpavel.vinotekalara.alertbar.dto.AlertRequest;
import eu.bilekpavel.vinotekalara.alertbar.service.AlertServiceInterface;
import eu.bilekpavel.vinotekalara.app.dto.Allow;
import eu.bilekpavel.vinotekalara.app.dto.Color;
import eu.bilekpavel.vinotekalara.superadmin.AdminPageContentProviderInterface;
import eu.bilekpavel.vinotekalara.superadmin.SuperAdminController;
import eu.bilekpavel.vinotekalara.translator.api.Translator;
import eu.bilekpavel.vinotekalara.translator.dto.LocalizedStringRequest;
import eu.bilekpavel.vinotekalara.translator.impl.TranslatorDataFactory;
import eu.bilekpavel.vinotekalara.translator.impl.TranslatorRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
// NOTE: this inherits mapping '/super-admin'
public class AlertAdminController extends SuperAdminController {

    private final AlertServiceInterface service;
    private final TranslatorDataFactory translatorDataProvider;

    public AlertAdminController(
            TranslatorRegistry LOCALES,
            AlertServiceInterface alertService,
            TranslatorDataFactory translatorDataFactory,
            AdminPageContentProviderInterface CONTENT_PROVIDER
    ) {
        super(LOCALES, CONTENT_PROVIDER);
        service = alertService;
        translatorDataProvider = translatorDataFactory;
    }

    @GetMapping("/alert")
    public String alertAdmin(Model model,
                             @RequestParam(name = "lang", required = false, defaultValue = "cs") String lang,
                             @RequestParam(name = "message", required = false) String message
    ) {
        Translator locale = LOCALES.getLocale(lang);

        model.addAttribute("_alertBars", service.getAllLocalized(locale.getLang(), false));
        model.addAttribute("_isAlertBarAllowed", service.isAllowed());
        model.addAttribute("_isAlertBarDisplayed", service.isDisplayed());
        model.addAttribute("_message", message == null ? "" : message);
        return "/admin/alert-bar/index";
    }

    @GetMapping("/alert/{id}")
    public String viewAlert(Model model,
                            @PathVariable int id,
                            @RequestParam(name = "lang", required = false, defaultValue = "cs") String lang) {

        Translator locale = LOCALES.getLocale(lang);

        model.addAttribute("_alertBar", service.get(id).get());
        model.addAttribute("_localizationWidget", translatorDataProvider.create(locale));
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

    @PostMapping("/alert/{id}/color")
    public String updateColor(@PathVariable int id,
                              Color color) {
        service.updateColor(id, color);
        return "redirect:/super-admin/alert/" + id;
    }

    @PostMapping("/alert/{id}")
    public String updateLocalization(@PathVariable int id,
                                     LocalizedStringRequest request) {
        service.updateLocalization(id, request);
        return "redirect:/super-admin/alert/" + id;
    }

    @PostMapping("/alert/activate/{id}")
    public String activate(@PathVariable int id) {
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
            return "redirect:/super-admin/alert";
        }
        return "redirect:/super-admin/alert";
    }

    @PostMapping("/alert/create")
    public String create(RedirectAttributes attributes) {
        service.create(
                new AlertRequest(List.of(
                        new LocalizedStringRequest("Základní text", "cz"),
                        new LocalizedStringRequest("Base text", "en"),
                        new LocalizedStringRequest("Basistext", "de")),
                        "#FFF")
        );
        attributes.addAttribute("message", "Successfully created");
        return "redirect:/super-admin/alert";
    }
}
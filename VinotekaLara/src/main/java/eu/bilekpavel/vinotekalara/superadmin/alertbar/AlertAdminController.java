package eu.bilekpavel.vinotekalara.superadmin.alertbar;

import eu.bilekpavel.vinotekalara.alertbar.service.AlertServiceInterface;
import eu.bilekpavel.vinotekalara.app.Color;
import eu.bilekpavel.vinotekalara.superadmin.SuperAdminController;
import eu.bilekpavel.vinotekalara.translator.api.Translator;
import eu.bilekpavel.vinotekalara.translator.dto.LocalizedStringRequest;
import eu.bilekpavel.vinotekalara.translator.impl.TranslatorDataFactory;
import eu.bilekpavel.vinotekalara.translator.impl.TranslatorRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
// NOTE: this inherits mapping '/super-admin'
public class AlertAdminController extends SuperAdminController {

    private final AlertServiceInterface service;
    private final TranslatorDataFactory translatorDataProvider;

    public AlertAdminController(
            TranslatorRegistry LOCALES,
            AlertServiceInterface alertService,
            TranslatorDataFactory translatorDataFactory
    ) {
        super(LOCALES);
        service = alertService;
        translatorDataProvider = translatorDataFactory;
    }

    @GetMapping("/alert")
    public String alertAdmin(Model model,
                             @RequestParam(name = "lang", required = false, defaultValue = "cs") String lang) {

        Translator locale = LOCALES.getLocale(lang);

        model.addAttribute("_alertBars", service.getAllLocalized(locale.getLang()));
        return "admin_alert";
    }

    @GetMapping("/alert/{id}")
    public String viewAlert(Model model,
                            @PathVariable int id,
                            @RequestParam(name = "lang", required = false, defaultValue = "cs") String lang) {

        Translator locale = LOCALES.getLocale(lang);

        model.addAttribute("_alertBar", service.get(id));
        model.addAttribute("_localizationWidget", translatorDataProvider.create(locale));
        return "admin_alert_edit";
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
}

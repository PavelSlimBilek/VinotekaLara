package eu.bilekpavel.vinotekalara.superadmin.modules.openinghours;

import eu.bilekpavel.vinotekalara.app.config.AppConfig;
import eu.bilekpavel.vinotekalara.app.dto.Allow;
import eu.bilekpavel.vinotekalara.openinghours.dto.DailyHoursRequest;
import eu.bilekpavel.vinotekalara.openinghours.service.WeeklyHoursServiceInterface;
import eu.bilekpavel.vinotekalara.superadmin.AdminPageContentProviderInterface;
import eu.bilekpavel.vinotekalara.superadmin.SuperAdminController;
import eu.bilekpavel.vinotekalara.translator.api.Translator;
import eu.bilekpavel.vinotekalara.translator.impl.TranslatorRegistry;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.DayOfWeek;

@Controller
public class HoursAdminController extends SuperAdminController {

    private final WeeklyHoursServiceInterface service;
    private final AppConfig config;

    public HoursAdminController(
            WeeklyHoursServiceInterface service,
            TranslatorRegistry LOCALES,
            AdminPageContentProviderInterface CONTENT_PROVIDER,
            AppConfig config
    ) {
        super(LOCALES, CONTENT_PROVIDER);
        this.service = service;
        this.config = config;
    }

    @GetMapping("/hours")
    public String list(
            Model model,
            @RequestParam(required = false) String message,
            @RequestParam(required = false) String lang,
            RedirectAttributes attributes
    ) {
        Translator locale = lang == null || lang.isEmpty() || !LOCALES.isOnTheList(lang)
                ? LOCALES.getLocale(config.getDEFAULT().getCode())
                : LOCALES.getLocale(lang);

        model.addAttribute("_openingHours", service.getWidgetData());
        model.addAttribute("_areAfternoonHoursAllowed", service.areAfternoonHoursAllowed());
        model.addAttribute("_locale", CONTENT_PROVIDER.getLocalizedAdminPage(locale.getAdminTranslator()));
        model.addAttribute("_message", message == null ? "" : message);
        attributes.addAttribute("lang", locale.getCode());
        return "admin/hours/index";
    }

    @GetMapping("/hours/{id}")
    public String detail(
            Model model,
            @PathVariable int id,
            @RequestParam(required = false) String lang,
            RedirectAttributes attributes
    ) {
        Translator locale = lang == null || lang.isEmpty() || !LOCALES.isOnTheList(lang)
                ? LOCALES.getLocale(config.getDEFAULT().getCode())
                : LOCALES.getLocale(lang);

        model.addAttribute("_openingHours", service.get(id));
        model.addAttribute("_areAfternoonHoursAllowed", service.areAfternoonHoursAllowed());
        model.addAttribute("_locale", CONTENT_PROVIDER.getLocalizedAdminPage(locale.getAdminTranslator()));
        attributes.addAttribute("lang", locale.getCode());

        return "/admin/hours/detail";
    }

    @PostMapping("/hours/allow-afternoon-hours")
    public String allowAfternoonHours(@ModelAttribute Allow dto) {
        service.allowAfternoonHours(dto.isAllowed());
        return "redirect:/super-admin/hours";
    }

    @PostMapping("/hours/{id}/day/{day}")
    public String updateDailyHours(
            @PathVariable int id,
            @PathVariable String day,
            @ModelAttribute DailyHoursRequest data
            ) {
        DayOfWeek dayOfWeek = DayOfWeek.valueOf(day.toUpperCase());
        service.update(id, dayOfWeek, data);
        return "redirect:/super-admin/hours/" + id;
    }

    @PostMapping("/hours/{id}/activate")
    public String activate(
            @PathVariable int id,
            HttpServletRequest http
    ) {
        service.activate(id);
        String referer = http.getHeader("Referer");
        if (referer != null) {
            return "redirect:" + referer;
        } else {
            return "redirect:/super-admin/hours/";
        }
    }

    @PostMapping("/hours/{id}/identifier")
    public String setIdentifier(@PathVariable int id, @RequestParam String name) {
        service.setIdentifier(id, name);
        return "redirect:/super-admin/hours/" + id;
    }

    @PostMapping("/hours/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes attributes) {
        try {
            service.delete(id);
        } catch (RuntimeException e) {
            attributes.addAttribute("message", e.getMessage());
            return "redirect:/super-admin/hours";
        }
        return "redirect:/super-admin/hours";
    }

    @PostMapping("/hours/create")
    public String create(@RequestParam String name, RedirectAttributes attributes) {
        service.create(name);
        attributes.addAttribute("message", "Successfully created");
        return "redirect:/super-admin/hours";
    }
}

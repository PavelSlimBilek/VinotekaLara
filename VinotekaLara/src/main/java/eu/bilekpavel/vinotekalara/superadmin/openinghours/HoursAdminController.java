package eu.bilekpavel.vinotekalara.superadmin.openinghours;

import eu.bilekpavel.vinotekalara.app.Allow;
import eu.bilekpavel.vinotekalara.openinghours.dto.DailyHoursRequest;
import eu.bilekpavel.vinotekalara.openinghours.service.WeeklyHoursServiceInterface;
import eu.bilekpavel.vinotekalara.superadmin.SuperAdminController;
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

    public HoursAdminController(
            WeeklyHoursServiceInterface service,
            TranslatorRegistry LOCALES
    ) {
        super(LOCALES);
        this.service = service;
    }

    @GetMapping("/hours")
    public String list(Model model, @RequestParam(required = false) String message) {
        model.addAttribute("_openingHours", service.getWidgetData());
        model.addAttribute("_areAfternoonHoursAllowed", service.areAfternoonHoursAllowed());
        model.addAttribute("_message", message == null ? "" : message);
        return "admin/hours/index";
    }

    @GetMapping("/hours/{id}")
    public String detail(Model model, @PathVariable int id) {
        model.addAttribute("_openingHours", service.get(id));
        model.addAttribute("_areAfternoonHoursAllowed", service.areAfternoonHoursAllowed());
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

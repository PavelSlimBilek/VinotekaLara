package eu.bilekpavel.vinotekalara.superadmin.openinghours;

import eu.bilekpavel.vinotekalara.openinghours.service.WeeklyHoursServiceInterface;
import eu.bilekpavel.vinotekalara.superadmin.SuperAdminController;
import eu.bilekpavel.vinotekalara.translator.impl.TranslatorRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String list(Model model) {
        model.addAttribute("_openingHours", service.getAll());
        return "admin/hours/index";
    }

    @GetMapping("/hours/{id}")
    public String detail(Model model, @PathVariable int id) {
        model.addAttribute("_openingHours", service.get(id));
        return "/admin/hours/detail";
    }

    @PostMapping("/hours/{id}/day/{day}")
    public String updateDailyHours(Model model, @PathVariable int id, @PathVariable String day) {
        DayOfWeek dayOfWeek = DayOfWeek.valueOf(day.toUpperCase());
        return "redirect:/super-admin/hours/" + id;
    }
}

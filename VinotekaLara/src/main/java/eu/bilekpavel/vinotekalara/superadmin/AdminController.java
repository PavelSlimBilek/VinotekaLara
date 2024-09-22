package eu.bilekpavel.vinotekalara.superadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/super-admin")
    public String baseView() {
        return "/admin/index";
    }
}

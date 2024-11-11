package eu.bilekpavel.vinotekalara.superadmin.modules.news;

import eu.bilekpavel.vinotekalara.superadmin.controller.SuperAdminController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewsAdminController extends SuperAdminController {

    @GetMapping("/news")
    public String index() {
        return "admin/news/index";
    }

    @GetMapping("/news/{id}")
    public String detail() {
        return "admin/news/detail";
    }
}

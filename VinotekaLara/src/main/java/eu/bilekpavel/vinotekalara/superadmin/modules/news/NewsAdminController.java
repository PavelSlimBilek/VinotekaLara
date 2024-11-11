package eu.bilekpavel.vinotekalara.superadmin.modules.news;

import eu.bilekpavel.vinotekalara.news.service.NewsServiceInterface;
import eu.bilekpavel.vinotekalara.superadmin.controller.SuperAdminController;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class NewsAdminController extends SuperAdminController {

    private final NewsServiceInterface service;

    @GetMapping("/news")
    public String index(
            Model model
    ) {
        model.addAttribute("_news", service.getAll());
        return "admin/news/index";
    }

    @GetMapping("/news/{id}")
    public String detail() {
        return "admin/news/detail";
    }
}

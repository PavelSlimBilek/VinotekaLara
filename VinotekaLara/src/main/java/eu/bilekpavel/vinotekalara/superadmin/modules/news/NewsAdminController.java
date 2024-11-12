package eu.bilekpavel.vinotekalara.superadmin.modules.news;

import eu.bilekpavel.vinotekalara.app.translator.CoreTranslatorDataFactoryInterface;
import eu.bilekpavel.vinotekalara.news.service.NewsServiceInterface;
import eu.bilekpavel.vinotekalara.news.translator.NewsTranslatorDataFactoryInterface;
import eu.bilekpavel.vinotekalara.superadmin.controller.SuperAdminController;
import eu.bilekpavel.vinotekalara.translator.api.Translator;
import eu.bilekpavel.vinotekalara.translator.service.TranslatorServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class NewsAdminController extends SuperAdminController {

    private final NewsServiceInterface service;
    private final TranslatorServiceInterface translatorService;

    private final NewsTranslatorDataFactoryInterface newsLocalizationDataProvider;
    private final CoreTranslatorDataFactoryInterface coreLocalizationDataProvider;

    @GetMapping("/news")
    public String index(
            Model model,
            @RequestParam(value = "lang", required = false) String langCode
    ) {
        Translator locale = translatorService.getLocale(langCode);

        model.addAttribute("_coreLocalization", coreLocalizationDataProvider.create(locale.coreTranslator()));
        model.addAttribute("_newsLocalization", newsLocalizationDataProvider.create(locale.newsTranslator()));
        model.addAttribute("_news", service.getAllLocalized(locale.getLang(), false));

        return "admin/news/index";
    }

    @GetMapping("/news/{id}")
    public String detail(
            Model model,
            @PathVariable int id
    ) {
        model.addAttribute("_news", service.get(id));
        return "admin/news/detail";
    }

    @PostMapping("/news/{id}/delete")
    public String delete(@PathVariable int id) {
        service.softDelete(id);
        return "redirect:/super-admin/news";
    }

    @PostMapping("/news/{id}/hide")
    public String hide(@PathVariable int id) {
        service.hide(id);
        return "redirect:/super-admin/news";
    }

    @PostMapping("/news/{id}/publish")
    public String publish(@PathVariable int id) {
        service.publish(id);
        return "redirect:/super-admin/news";
    }
}

package eu.bilekpavel.vinotekalara.superadmin;

import eu.bilekpavel.vinotekalara.app.config.AppConfig;
import eu.bilekpavel.vinotekalara.translator.api.Translator;
import eu.bilekpavel.vinotekalara.translator.impl.TranslatorRegistry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@AllArgsConstructor
public class AdminController {

    private final AdminPageContentProviderInterface contentProvider;
    private final TranslatorRegistry locales;

    private final AppConfig config;

    @GetMapping("/super-admin")
    public String baseView(
            Model model,
            @RequestParam(required = false) String lang,
            RedirectAttributes attributes
    ) {
        Translator locale = lang == null || lang.isEmpty() || !locales.isOnTheList(lang)
                ? locales.getLocale(config.getDEFAULT().getCode())
                : locales.getLocale(lang);

        model.addAttribute("_locale", contentProvider.getLocalizedAdminPage(locale.getAdminTranslator()));
        attributes.addAttribute("lang", lang);
        return "/admin/index";
    }
}

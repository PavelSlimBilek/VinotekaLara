package eu.bilekpavel.vinotekalara.superadmin;

import eu.bilekpavel.vinotekalara.translator.impl.TranslatorRegistry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/super-admin")
@AllArgsConstructor
public abstract class SuperAdminController {

    protected final TranslatorRegistry LOCALES;
    protected final AdminPageContentProviderInterface CONTENT_PROVIDER;

}

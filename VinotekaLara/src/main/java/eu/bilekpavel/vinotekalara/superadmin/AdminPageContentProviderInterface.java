package eu.bilekpavel.vinotekalara.superadmin;

import eu.bilekpavel.vinotekalara.superadmin.dto.LocalizedAdminContent;
import eu.bilekpavel.vinotekalara.superadmin.translator.AdminTranslatorInterface;

public interface AdminPageContentProviderInterface {
    LocalizedAdminContent getLocalizedAdminPage(AdminTranslatorInterface translator);
}

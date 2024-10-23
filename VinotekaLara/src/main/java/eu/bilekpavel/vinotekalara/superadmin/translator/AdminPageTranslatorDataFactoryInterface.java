package eu.bilekpavel.vinotekalara.superadmin.translator;

import eu.bilekpavel.vinotekalara.superadmin.translator.dto.AdminPageTranslatorData;

public interface AdminPageTranslatorDataFactoryInterface {
    AdminPageTranslatorData create(AdminPageTranslator locale);
}

package eu.bilekpavel.vinotekalara.superadmin.translator.internal;

import eu.bilekpavel.vinotekalara.superadmin.translator.AdminPageTranslator;
import eu.bilekpavel.vinotekalara.superadmin.translator.AdminPageTranslatorDataFactoryInterface;
import eu.bilekpavel.vinotekalara.superadmin.translator.dto.AdminPageTranslatorData;
import org.springframework.stereotype.Component;

@Component
public final class AdminPageTranslatorDataFactory implements AdminPageTranslatorDataFactoryInterface {

    @Override
    public AdminPageTranslatorData create(AdminPageTranslator locale) {
        return new AdminPageTranslatorData(
                locale.title()
        );
    }
}

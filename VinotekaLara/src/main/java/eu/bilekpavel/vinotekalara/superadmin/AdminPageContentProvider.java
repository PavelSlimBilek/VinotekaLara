package eu.bilekpavel.vinotekalara.superadmin;

import eu.bilekpavel.vinotekalara.superadmin.dto.LocalizedAdminContent;
import eu.bilekpavel.vinotekalara.superadmin.translator.AdminTranslatorInterface;
import org.springframework.stereotype.Component;

@Component
public class AdminPageContentProvider implements AdminPageContentProviderInterface {

    @Override
    public LocalizedAdminContent getLocalizedAdminPage(AdminTranslatorInterface translator) {
        return new LocalizedAdminContent(
                translator.getSelectDefaultLanguageTranslation(),
                translator.getToggleLanguagesMessage(),
                translator.getAppSettingsTranslation(),
                translator.getUpdateLocalizationsTranslation(),
                translator.getBackgroundColorTranslation(),
                translator.getRedTranslation(),
                translator.getGreenTranslation(),
                translator.getBlueTranslation(),
                translator.getFontColorTranslation(),
                translator.getSelectFontTranslation()
        );
    }
}

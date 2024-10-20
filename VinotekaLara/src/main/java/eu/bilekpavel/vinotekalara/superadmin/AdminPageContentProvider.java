package eu.bilekpavel.vinotekalara.superadmin;

import eu.bilekpavel.vinotekalara.superadmin.dto.LocalizedAdminContent;
import eu.bilekpavel.vinotekalara.superadmin.translator.AdminTranslatorInterface;
import org.springframework.stereotype.Component;

@Component
public class AdminPageContentProvider implements AdminPageContentProviderInterface {

    @Override
    public LocalizedAdminContent getLocalizedAdminPage(AdminTranslatorInterface translator) {
        return new LocalizedAdminContent(
                translator.getSettingsTranslation(),
                translator.getOpeningHoursTranslation(),
                translator.getAppTranslation(),
                translator.getAlertBarTranslation(),
                translator.getAllowTranslation(),
                translator.getForbidTranslation(),
                translator.getActivateTranslation(),
                translator.getSubmitTranslation(),
                translator.getEditTranslation(),
                translator.getBackTranslation(),
                translator.getSelectGlobalHoursTranslation(),
                translator.getActiveHoursTranslation(),
                translator.getDeleteTranslation(),
                translator.getCreateTranslation(),
                translator.getNameTranslation(),
                translator.getApplyTranslation(),
                translator.getSelectGlobalHoursTranslation(),
                translator.getToggleLanguagesMessage(),
                translator.getAppSettingsTranslation()
        );
    }
}
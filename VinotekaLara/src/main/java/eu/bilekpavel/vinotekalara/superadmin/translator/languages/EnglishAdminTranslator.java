package eu.bilekpavel.vinotekalara.superadmin.translator.languages;

import eu.bilekpavel.vinotekalara.superadmin.translator.AbstractAdminTranslator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("englishAdmin")
public final class EnglishAdminTranslator extends AbstractAdminTranslator {

    public EnglishAdminTranslator() {
        super(
                "settings",
                "opening hours",
                "application",
                "allow",
                "forbid",
                "activate",
                "submit",
                "edit",
                "back",
                "select global opening hours",
                "current opening hours",
                "remove",
                "create",
                "name",
                "apply",
                "select default language",
                "allow/forbid languages",
                "app settings",
                "update localizations",
                "background color",
                "red",
                "green",
                "blue",
                "set opening hours",
                "font color",
                "select font",
                "preview"
        );
    }
}

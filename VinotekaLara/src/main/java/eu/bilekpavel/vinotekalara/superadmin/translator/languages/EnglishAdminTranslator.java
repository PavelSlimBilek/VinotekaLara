package eu.bilekpavel.vinotekalara.superadmin.translator.languages;

import eu.bilekpavel.vinotekalara.superadmin.translator.AbstractAdminTranslator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("englishAdmin")
public class EnglishAdminTranslator extends AbstractAdminTranslator {

    public EnglishAdminTranslator() {
        super(
                "opening hours",
                "application",
                "alert bar");
    }
}

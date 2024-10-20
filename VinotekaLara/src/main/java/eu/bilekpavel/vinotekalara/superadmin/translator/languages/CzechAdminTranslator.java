package eu.bilekpavel.vinotekalara.superadmin.translator.languages;

import eu.bilekpavel.vinotekalara.superadmin.translator.AbstractAdminTranslator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("czechAdmin")
public class CzechAdminTranslator extends AbstractAdminTranslator {
    public CzechAdminTranslator() {
        super(
                "otevírací hodiny",
                "aplikace",
                "lišta upozornění"
        );
    }
}

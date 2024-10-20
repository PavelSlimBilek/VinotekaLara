package eu.bilekpavel.vinotekalara.superadmin.translator.languages;

import eu.bilekpavel.vinotekalara.superadmin.translator.AbstractAdminTranslator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("czechAdmin")
public class CzechAdminTranslator extends AbstractAdminTranslator {
    public CzechAdminTranslator() {
        super(
                "nastavení",
                "otevírací hodiny",
                "aplikace",
                "lišta upozornění",
                "povolit",
                "zakázat",
                "aktivovat",
                "odeslat",
                "upravit",
                "zpět",
                "zvolte globální otevírací dobu",
                "aktuální otevírací doba"
        );
    }
}

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
                "aktuální otevírací doba",
                "smazat",
                "vytvořit",
                "název",
                "použít",
                "zvolte výchozí jazyk",
                "povolit/zakázat jazyky",
                "nastavení aplikace",
                "povolit notifikačn lištu",
                "zobrazit notifikační lištu",
                "zvolte aktivní lištu",
                "vytvořit lištu",
                "aktualizovat lokalizace",
                "barva pozadí",
                "červená",
                "zelená",
                "modrá"
        );
    }
}

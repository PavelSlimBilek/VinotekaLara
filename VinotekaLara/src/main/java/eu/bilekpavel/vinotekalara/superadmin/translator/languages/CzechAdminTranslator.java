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
                "aplikace",
                "povolit",
                "zakázat",
                "aktivovat",
                "odeslat",
                "upravit",
                "zpět",
                "smazat",
                "vytvořit",
                "název",
                "použít",
                "zvolte výchozí jazyk",
                "povolit/zakázat jazyky",
                "nastavení aplikace",
                "aktualizovat lokalizace",
                "barva pozadí",
                "červená",
                "zelená",
                "modrá",
                "barva písma",
                "zvolte písmo",
                "náhled"
        );
    }
}

package eu.bilekpavel.vinotekalara.superadmin.translator.languages;

import eu.bilekpavel.vinotekalara.superadmin.translator.AbstractAdminTranslator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("germanAdmin")
public class GermanAdminTranslator extends AbstractAdminTranslator {
    public GermanAdminTranslator() {
        super(
                "Öffnungszeiten",
                "Anwendung",
                "Alarmleiste"
        );
    }
}

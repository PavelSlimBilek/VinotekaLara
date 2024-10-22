package eu.bilekpavel.vinotekalara.superadmin.translator.languages;

import eu.bilekpavel.vinotekalara.superadmin.translator.AbstractAdminTranslator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("germanAdmin")
public class GermanAdminTranslator extends AbstractAdminTranslator {
    public GermanAdminTranslator() {
        super(
                "Einstellungen",
                "Öffnungszeiten",
                "Anwendung",
                "erlauben",
                "verbieten",
                "aktivieren",
                "absenden",
                "bearbeiten",
                "zurück",
                "Globale Öffnungszeiten auswählen",
                "Aktuelle Öffnungszeiten",
                "entfernen",
                "erstellen",
                "Bezeichnung",
                "anwenden",
                "Standard Sprache auswählen",
                "Sprachen erlauben/verbieten",
                "App-Einstellungen",
                "Lokalisierungen aktualisieren",
                "Hintergrundfarbe",
                "Rot",
                "Grün",
                "Blau",
                "Öffnungszeiten bearbeiten",
                "Schriftfarbe",
                "Schriftart auswählen",
                "Vorschau"
        );
    }
}

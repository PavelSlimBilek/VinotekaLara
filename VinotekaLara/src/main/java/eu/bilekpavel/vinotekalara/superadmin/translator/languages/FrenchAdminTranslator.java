package eu.bilekpavel.vinotekalara.superadmin.translator.languages;

import eu.bilekpavel.vinotekalara.superadmin.translator.AbstractAdminTranslator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("frenchAdmin")
public class FrenchAdminTranslator extends AbstractAdminTranslator {
    public FrenchAdminTranslator() {
        super(
                "paramètres",
                "horaires d'ouverture",
                "application",
                "barre d'alerte",
                "autoriser",
                "interdire",
                "activer",
                "soumettre",
                "modifier",
                "retour",
                "sélectionner les horaires d'ouverture globaux",
                "horaires d'ouverture actuels",
                "supprimer",
                "créer",
                "nom",
                "appliquer",
                "sélectionner la langue par défaut",
                "autoriser/interdire les langues",
                "paramètres de l'application",
                "autoriser la barre d'alerte",
                "afficher la barre d'alerte",
                "sélectionner la barre d'alerte active",
                "créer une nouvelle alerte",
                "mettre à jour les localisations",
                "couleur de fond",
                "rouge",
                "vert",
                "bleu",
                "modifier les horaires d'ouverture"
        );
    }
}

package eu.bilekpavel.vinotekalara.alertbar.translator;

import eu.bilekpavel.vinotekalara.alertbar.translator.dto.AlertBarTranslatorData;

public interface AlertBarTranslatorDataFactoryInterface {
    AlertBarTranslatorData create(AlertBarTranslator locale);
}

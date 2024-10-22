package eu.bilekpavel.vinotekalara.alertbar.translator.internal;

import eu.bilekpavel.vinotekalara.alertbar.translator.AlertBarTranslator;
import eu.bilekpavel.vinotekalara.alertbar.translator.AlertBarTranslatorDataFactoryInterface;
import eu.bilekpavel.vinotekalara.alertbar.translator.dto.AlertBarTranslatorData;
import org.springframework.stereotype.Component;

@Component
public class AlertBarTranslatorDataFactory implements AlertBarTranslatorDataFactoryInterface {

    @Override
    public AlertBarTranslatorData create(AlertBarTranslator locale) {
        return new AlertBarTranslatorData(
                locale.alertBar(),
                locale.allowAlertBar(),
                locale.displayAlertBar(),
                locale.selectActiveAlertBar(),
                locale.createAlertBar()
        );
    }
}

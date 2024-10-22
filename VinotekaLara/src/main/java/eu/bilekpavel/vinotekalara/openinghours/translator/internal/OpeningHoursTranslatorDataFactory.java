package eu.bilekpavel.vinotekalara.openinghours.translator.internal;

import eu.bilekpavel.vinotekalara.openinghours.translator.OpeningHoursTranslator;
import eu.bilekpavel.vinotekalara.openinghours.translator.OpeningHoursTranslatorDataFactoryInterface;
import eu.bilekpavel.vinotekalara.openinghours.translator.dto.WeeklyHoursTranslatorData;
import org.springframework.stereotype.Component;

@Component
public class OpeningHoursTranslatorDataFactory implements OpeningHoursTranslatorDataFactoryInterface {
    @Override
    public WeeklyHoursTranslatorData create(OpeningHoursTranslator locale) {
        return new WeeklyHoursTranslatorData(
                locale.openingHours(),
                locale.selectHours(),
                locale.activeHours(),
                locale.setHours(),
                locale.day(),
                locale.monday(),
                locale.tuesday(),
                locale.wednesday(),
                locale.thursday(),
                locale.friday(),
                locale.saturday(),
                locale.sunday(),
                locale.start(),
                locale.end(),
                locale.morningHours(),
                locale.afternoonHours()
        );
    }
}

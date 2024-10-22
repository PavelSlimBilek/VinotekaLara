package eu.bilekpavel.vinotekalara.openinghours.translator;

import eu.bilekpavel.vinotekalara.openinghours.translator.dto.WeeklyHoursTranslatorData;

public interface OpeningHoursTranslatorDataFactoryInterface {
    WeeklyHoursTranslatorData create(OpeningHoursTranslator locale);
}

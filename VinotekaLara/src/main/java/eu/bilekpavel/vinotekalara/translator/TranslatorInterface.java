package eu.bilekpavel.vinotekalara.translator;

import eu.bilekpavel.vinotekalara.openinghours.dto.OpeningHours;

import java.util.List;

public interface TranslatorInterface {
    String transform(OpeningHours hours);
    List<String> transformAll(List<OpeningHours> hours);
    String isOpenedMessage(boolean isOpened);
}
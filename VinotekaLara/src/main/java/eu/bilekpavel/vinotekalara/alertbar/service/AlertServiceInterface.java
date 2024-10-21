package eu.bilekpavel.vinotekalara.alertbar.service;

import eu.bilekpavel.vinotekalara.alertbar.dto.AlertBarWidgetData;
import eu.bilekpavel.vinotekalara.alertbar.dto.AlertFullData;
import eu.bilekpavel.vinotekalara.alertbar.dto.AlertRequest;
import eu.bilekpavel.vinotekalara.app.dto.Color;
import eu.bilekpavel.vinotekalara.alertbar.dto.LocalizedAlert;
import eu.bilekpavel.vinotekalara.translator.dto.LocalizedStringRequest;
import eu.bilekpavel.vinotekalara.translator.language.Language;

import java.util.List;
import java.util.Optional;

public interface AlertServiceInterface {
    void create(AlertRequest request);

    LocalizedAlert getLocalized(int id, Language language);
    List<LocalizedAlert> getAllLocalized(Language lang, boolean allowRemoved);

    void updateBackgroundColor(int id, Color color);
    void updateFontColor(int id, Color color);

    void updateLocalization(int id, LocalizedStringRequest request);

    Optional<AlertFullData> get(int id);
    void setActive(int id);

    LocalizedAlert getActive(Language language);
    void allow(boolean isAllowed);
    void display(boolean isDisplayed);

    void toggle();
    boolean isAllowed(); // adjustable from super-admin

    boolean isDisplayed(); // adjustable from custom-admin

    void delete(int id);

    AlertBarWidgetData getWidgetData(Language lang);
}
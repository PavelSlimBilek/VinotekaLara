package eu.bilekpavel.vinotekalara.alertbar.service;

import eu.bilekpavel.vinotekalara.alertbar.dto.AlertBarWidgetData;
import eu.bilekpavel.vinotekalara.alertbar.dto.AlertFullData;
import eu.bilekpavel.vinotekalara.alertbar.dto.AlertRequest;
import eu.bilekpavel.vinotekalara.app.module.color.dto.Color;
import eu.bilekpavel.vinotekalara.alertbar.dto.LocalizedAlert;
import eu.bilekpavel.vinotekalara.translator.dto.LocalizedStringRequest;
import eu.bilekpavel.vinotekalara.translator.language.Language;

import java.util.List;

public interface AlertBarServiceInterface {
    void create(AlertRequest request);

    LocalizedAlert getLocalized(int id, Language language);
    List<LocalizedAlert> getAllLocalized(Language lang, boolean allowRemoved);

    void updateBackgroundColor(int id, Color color);
    void updateFontColor(int id, Color color);
    void updateColors(int id, Color background, Color font);

    void updateLocalization(int id, LocalizedStringRequest request);

    AlertFullData get(int id);
    void setActive(int id);

    LocalizedAlert getActive(Language language);
    void allow(boolean isAllowed);
    void display(boolean isDisplayed);

    boolean isAllowed();
    boolean isDisplayed();

    void delete(int id);

    AlertBarWidgetData getWidgetData(Language lang);
}
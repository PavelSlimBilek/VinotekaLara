package eu.bilekpavel.vinotekalara.news.service;

import eu.bilekpavel.vinotekalara.news.dto.NewsFullData;
import eu.bilekpavel.vinotekalara.news.dto.NewsRequest;
import eu.bilekpavel.vinotekalara.news.error.CannotHardRemoveNotSoftRemovedNewsException;
import eu.bilekpavel.vinotekalara.news.error.CannotRemoveActiveNewsException;
import eu.bilekpavel.vinotekalara.news.error.NewsNotFoundException;
import eu.bilekpavel.vinotekalara.news.error.NewsNotRemovedException;
import eu.bilekpavel.vinotekalara.news.translator.dto.LocalizedNews;
import eu.bilekpavel.vinotekalara.translator.language.Language;

import java.util.List;
import java.util.Optional;

public interface NewsServiceInterface {
    void allowModule(boolean allow);
    boolean isModuleAllowed();

    void displayModule(boolean display);
    boolean isModuleDisplayed();

    Optional<NewsFullData> get(int id);
    List<LocalizedNews> getAllLocalized(Language language, boolean allowRemoved);
    List<NewsFullData> getAll();

    NewsFullData create(NewsRequest request);
    void update(int id, NewsRequest request) throws NewsNotFoundException;

    void hardDelete(int id) throws CannotHardRemoveNotSoftRemovedNewsException, NewsNotFoundException;
    void softDelete(int id) throws CannotRemoveActiveNewsException, NewsNotFoundException;
    void restore(int id) throws NewsNotFoundException, NewsNotRemovedException;

    void publish(int id, boolean publish) throws NewsNotFoundException;
}

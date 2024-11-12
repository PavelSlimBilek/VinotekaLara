package eu.bilekpavel.vinotekalara.news.service;

import eu.bilekpavel.vinotekalara.news.dto.NewsFullData;
import eu.bilekpavel.vinotekalara.news.dto.NewsRequest;
import eu.bilekpavel.vinotekalara.news.translator.dto.LocalizedNews;
import eu.bilekpavel.vinotekalara.translator.language.Language;

import java.util.List;
import java.util.Optional;

public interface NewsServiceInterface {
    Optional<NewsFullData> get(int id);
    List<NewsFullData> getAll();
    NewsFullData create(NewsRequest request);
    void update(int id, NewsRequest request);
    void softDelete(int id);
    void activate(int id);
    void deactivate(int id);

    List<LocalizedNews> getAllLocalized(Language language, boolean allowRemoved);

    void hide(int id);
    void publish(int id);
}

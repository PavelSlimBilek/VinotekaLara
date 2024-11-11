package eu.bilekpavel.vinotekalara.news.service;

import eu.bilekpavel.vinotekalara.news.dto.NewsData;
import eu.bilekpavel.vinotekalara.news.dto.NewsRequest;

import java.util.List;
import java.util.Optional;

public interface NewsServiceInterface {
    Optional<NewsData> get(int id);
    List<NewsData> getAll();
    NewsData create(NewsRequest request);
    void update(int id, NewsRequest request);
}

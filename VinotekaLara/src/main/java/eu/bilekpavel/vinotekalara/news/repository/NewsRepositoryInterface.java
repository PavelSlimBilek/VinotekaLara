package eu.bilekpavel.vinotekalara.news.repository;

import eu.bilekpavel.vinotekalara.news.model.News;

import java.util.List;
import java.util.Optional;

public interface NewsRepositoryInterface {
    Optional<News> findById(int id);
    List<News> findAll();
    News save(News news);
    Optional<News> findByIsActive(boolean isActive);
}

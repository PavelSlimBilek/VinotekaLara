package eu.bilekpavel.vinotekalara.news.repository;

import eu.bilekpavel.vinotekalara.news.model.News;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class NewsInMemoryRepository implements NewsRepositoryInterface {
    private final Map<Integer, News> news;

    public NewsInMemoryRepository() {
        news = new HashMap<>();
    }

    @Override
    public Optional<News> findById(int id) {
        return Optional.of(news.get(id));
    }

    @Override
    public List<News> findAll() {
        return news.values().stream().toList();
    }

    @Override
    public News save(News news) {
        this.news.put(news.getId(), news);
        return news;
    }

    @Override
    public Optional<News> findByActive(boolean isActive) {
        return news.values().stream().filter(News::isActive).findFirst();
    }
}

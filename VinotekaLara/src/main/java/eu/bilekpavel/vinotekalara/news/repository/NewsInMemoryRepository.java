package eu.bilekpavel.vinotekalara.news.repository;

import eu.bilekpavel.vinotekalara.news.model.News;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@Qualifier("news_map_repository")
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
    public Optional<News> findByIsActive(boolean isActive) {
        return news.values().stream().filter(News::isActive).findFirst();
    }

    @Override
    public void delete(News news) {
        this.news.remove(news.getId());
    }
}

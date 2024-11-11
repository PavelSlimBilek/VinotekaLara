package eu.bilekpavel.vinotekalara.news.service;

import eu.bilekpavel.vinotekalara.news.dto.NewsData;
import eu.bilekpavel.vinotekalara.news.dto.NewsRequest;
import eu.bilekpavel.vinotekalara.news.error.NewsNotFoundException;
import eu.bilekpavel.vinotekalara.news.model.News;
import eu.bilekpavel.vinotekalara.news.repository.NewsRepositoryInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NewsService implements NewsServiceInterface {

    private final NewsRepositoryInterface repository;

    @Override
    public Optional<NewsData> get(int id) {
        Optional<News> optNews = repository.findById(id);
        return optNews.map(this::populate);
    }

    @Override
    public List<NewsData> getAll() {
        return repository.findAll().stream().map(this::populate).toList();
    }

    @Override
    public NewsData create(NewsRequest request) {
        News news = new News(request);
        return new NewsData(repository.save(news));
    }

    @Override
    public void update(int id, NewsRequest request) {
        Optional<News> optNews = repository.findById(id);
        if (optNews.isEmpty()) {
            throw new NewsNotFoundException(String.valueOf(id));
        }

        News news = optNews.get();
        news.setContent(request.content());
        repository.save(news);
    }

    private NewsData populate(News news) {
        return new NewsData(news.getId(), news.getContent());
    }
}

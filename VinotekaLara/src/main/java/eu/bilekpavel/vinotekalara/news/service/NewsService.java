package eu.bilekpavel.vinotekalara.news.service;

import eu.bilekpavel.vinotekalara.news.dto.NewsFullData;
import eu.bilekpavel.vinotekalara.news.dto.NewsRequest;
import eu.bilekpavel.vinotekalara.news.error.CannotRemoveActiveNewsException;
import eu.bilekpavel.vinotekalara.news.error.NewsNotFoundException;
import eu.bilekpavel.vinotekalara.news.model.News;
import eu.bilekpavel.vinotekalara.news.repository.NewsRepositoryInterface;
import eu.bilekpavel.vinotekalara.news.translator.dto.LocalizedNews;
import eu.bilekpavel.vinotekalara.translator.api.LocalizedStringFactoryInterface;
import eu.bilekpavel.vinotekalara.translator.dto.LocalizedString;
import eu.bilekpavel.vinotekalara.translator.error.TranslatorException;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class NewsService implements NewsServiceInterface {

    private final NewsRepositoryInterface repository;
    private final LocalizedStringFactoryInterface localizedStringFactory;

    public NewsService(
            @Qualifier("news_db_repository") NewsRepositoryInterface repository,
            LocalizedStringFactoryInterface localizedStringFactory
    ) {
        this.repository = repository;
        this.localizedStringFactory = localizedStringFactory;
    }

    @Override
    public Optional<NewsFullData> get(int id) {
        Optional<News> optNews = repository.findById(id);
        return optNews.map(this::populate);
    }

    @Override
    public List<NewsFullData> getAll() {
        return repository.findAll().stream().map(this::populate).toList();
    }

    @Override
    public NewsFullData create(NewsRequest request) throws TranslatorException {
        LocalizedString validTitle = localizedStringFactory.create(request.title());
        LocalizedString validContent = localizedStringFactory.create(request.content());

        News news = new News(validTitle, validContent);
        repository.save(news);
        return populate(news);
    }

    @Override
    public void update(
            int id,
            NewsRequest request
    ) {
        Optional<News> optNews = repository.findById(id);
        if (optNews.isEmpty()) {
            throw new NewsNotFoundException(String.valueOf(id));
        }

        LocalizedString validContent = localizedStringFactory.create(request.content());
        LocalizedString validTitle = localizedStringFactory.create(request.title());

        News news = optNews.get();
        news.updateContent(validContent);
        news.updateTitle(validTitle);
        repository.save(news);
    }

    @Override
    public void softDelete(int id) {
        Optional<News> optNews = repository.findById(id);
        if (optNews.isEmpty()) {
            throw new NewsNotFoundException(String.valueOf(id));
        }

        News news = optNews.get();
        if (news.isActive()) {
            throw new CannotRemoveActiveNewsException();
        }

        news.remove();
        repository.save(news);
    }

    @Override
    public void activate(int id) {
        Optional<News> optNews = repository.findById(id);
        if (optNews.isEmpty()) {
            throw new NewsNotFoundException(String.valueOf(id));
        }

        optNews.get().setActiveState();
        repository.save(optNews.get());
    }

    @Override
    public void deactivate(int id) {
        Optional<News> optNews = repository.findById(id);
        if (optNews.isEmpty()) {
            throw new NewsNotFoundException(String.valueOf(id));
        }

        optNews.get().setInactiveState();
        repository.save(optNews.get());
    }

    @Override
    public List<LocalizedNews> getAllLocalized(Language language, boolean allowRemoved) {
        return repository.findAll().stream()
                .filter(news -> allowRemoved || !news.isRemoved())
                .map(news -> populate(language, news))
                .toList();
    }

    private NewsFullData populate(News news) {
        Map<Language, LocalizedString> title = new HashMap<>();
        for (Map.Entry<Language, String> entry : news.getTitle().entrySet()) {
            title.put(
                    entry.getKey(),
                    localizedStringFactory.create(entry.getKey(), entry.getValue())
            );
        }

        Map<Language, LocalizedString> content = new HashMap<>();
        for (Map.Entry<Language, String> entry : news.getContent().entrySet()) {
            content.put(
                    entry.getKey(),
                    localizedStringFactory.create(entry.getKey(), entry.getValue())
            );
        }

        return new NewsFullData(news.getId(), title, content);
    }

    private LocalizedNews populate(Language language, News news) {
        return new LocalizedNews(
                news.getId(),
                news.isActive(),
                localizedStringFactory.create(language, news.getContent(language)),
                localizedStringFactory.create(language, news.getTitle(language))
        );
    }
}

package eu.bilekpavel.vinotekalara.news.service;

import eu.bilekpavel.vinotekalara.news.config.NewsConfig;
import eu.bilekpavel.vinotekalara.news.dto.NewsFullData;
import eu.bilekpavel.vinotekalara.news.dto.NewsRequest;
import eu.bilekpavel.vinotekalara.news.error.CannotRemoveActiveNewsException;
import eu.bilekpavel.vinotekalara.news.error.NewsNotFoundException;
import eu.bilekpavel.vinotekalara.news.error.NewsNotRemovedException;
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
    private final NewsConfig config;

    public NewsService(
            @Qualifier("news_db_repository") NewsRepositoryInterface repository,
            LocalizedStringFactoryInterface localizedStringFactory,
            NewsConfig config
    ) {
        this.repository = repository;
        this.localizedStringFactory = localizedStringFactory;
        this.config = config;
    }

    @Override
    public void allowModule(boolean allow) {
        config.setAllowed(allow);
    }

    @Override
    public boolean isModuleAllowed() {
        return config.isAllowed();
    }

    @Override
    public void displayModule(boolean display) {
        config.setDisplayed(display);
    }

    @Override
    public boolean isModuleDisplayed() {
        return config.isDisplayed();
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
    ) throws NewsNotFoundException {
        News news = findOrThrow(id);
        LocalizedString validContent = localizedStringFactory.create(request.content());
        LocalizedString validTitle = localizedStringFactory.create(request.title());

        news.updateContent(validContent);
        news.updateTitle(validTitle);
        repository.save(news);
    }

    @Override
    public void hardDelete(int id) throws NewsNotRemovedException {
        News news = findOrThrow(id);
        repository.delete(news);
    }

    @Override
    public void softDelete(int id) throws CannotRemoveActiveNewsException, NewsNotFoundException {
        News news = findOrThrow(id);
        if (news.isActive()) {
            throw new CannotRemoveActiveNewsException();
        }

        news.remove();
        repository.save(news);
    }

    @Override
    public void restore(int id) throws NewsNotRemovedException, NewsNotFoundException {
        News news = findOrThrow(id);
        if (!news.isRemoved()) {
            throw new NewsNotRemovedException(String.valueOf(id));
        }
        news.restore();
        repository.save(news);
    }

    public void publish(int id, boolean publish) throws NewsNotFoundException {
        News news = findOrThrow(id);
        if (publish) {
            news.setActiveState();
        } else {
            news.setInactiveState();
        }
        repository.save(news);
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

    private News findOrThrow(int id) throws NewsNotFoundException {
        Optional<News> optNews = repository.findById(id);
        if (optNews.isEmpty()) {
            throw new NewsNotFoundException(String.valueOf(id));
        }
        return optNews.get();
    }
}

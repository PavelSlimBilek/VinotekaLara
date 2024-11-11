package eu.bilekpavel.vinotekalara.news.repository;

import eu.bilekpavel.vinotekalara.news.model.News;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Qualifier("news_db_repository")
public interface NewsRepository extends JpaRepository<News, Integer>, NewsRepositoryInterface {

    @Override
    Optional<News> findById(int id);

    @Override
    List<News> findAll();

    @Override
    News save(News news);

    @Override
    Optional<News> findByIsActive(boolean isActive);
}

package eu.bilekpavel.vinotekalara.news.dto;

import eu.bilekpavel.vinotekalara.news.model.News;

public record NewsData(
        int id,
        String content
) {
    public NewsData(News entity) {
        this(entity.getId(), entity.getContent());
    }
}

package pl.training.blog.application;

import lombok.RequiredArgsConstructor;
import pl.training.blog.domain.Article;
import pl.training.blog.domain.ArticleUpdate;
import pl.training.blog.ports.ArticleRepository;

import java.util.UUID;

@RequiredArgsConstructor
public class ArticleAuthorActions {

    private final ArticleRepository articleRepository;

    public UUID create(ArticleTemplate articleTemplate) {
        var article = Article.builder()
                .title(articleTemplate.getTitle())
                .author(articleTemplate.getAuthor())
                .content(articleTemplate.getContent())
                .category(articleTemplate.getCategory())
                .build();
        return articleRepository.save(article).getId();
    }

    public void delete(UUID articleId) {
        articleRepository.deleteById(articleId);
    }

    public void update(UUID articleId, ArticleUpdate articleUpdate) {
        articleRepository.apply(articleId, article -> article.patch(articleUpdate));
    }

    public void publish(UUID articleId) {
        articleRepository.apply(articleId, Article::publish);
    }

}

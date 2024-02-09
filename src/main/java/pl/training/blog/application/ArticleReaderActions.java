package pl.training.blog.application;

import lombok.RequiredArgsConstructor;
import pl.training.blog.domain.Article;
import pl.training.blog.domain.Comment;
import pl.training.blog.ports.ArticleRepository;

import java.util.UUID;

@RequiredArgsConstructor
public class ArticleReaderActions {

    private final ArticleRepository articleRepository;

    public void like(UUID articleId) {
        articleRepository.apply(articleId, Article::like);
    }

    public void dislike(UUID articleId) {
        articleRepository.apply(articleId, Article::dislike);
    }

    public void comment(UUID articleId, Comment comment) {
        articleRepository.apply(articleId, article -> article.addComment(comment));
    }

}

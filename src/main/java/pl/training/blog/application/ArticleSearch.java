package pl.training.blog.application;

import lombok.RequiredArgsConstructor;
import pl.training.blog.common.PageDefinition;
import pl.training.blog.common.ResultPage;
import pl.training.blog.domain.Article;
import pl.training.blog.domain.ArticleCategory;
import pl.training.blog.domain.Tag;
import pl.training.blog.ports.ArticleRepository;

import java.util.Set;
import java.util.UUID;

@RequiredArgsConstructor
public class ArticleSearch {

    private final ArticleRepository articleRepository;

    public Article findByUid(UUID id) {
        return articleRepository.findById(id)
                .orElseThrow(ArticleNotFoundException::new);
    }

    public ResultPage<ArticleView> findByCategory(ArticleCategory category, PageDefinition pageDefinition) {
        return articleRepository.findByCategory(category, pageDefinition);
    }

    public ResultPage<ArticleView> findByTags(Set<Tag> tags, PageDefinition pageDefinition) {
        return articleRepository.findByTags(tags, pageDefinition);
    }

    public ResultPage<ArticleView> findByCategoryAndTags(ArticleCategory category, Set<Tag> tags, PageDefinition pageDefinition) {
        return articleRepository.findByCategoryAndTags(category, tags, pageDefinition);
    }

}
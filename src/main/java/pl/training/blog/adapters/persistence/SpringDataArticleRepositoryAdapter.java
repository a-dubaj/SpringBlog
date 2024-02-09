package pl.training.blog.adapters.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import pl.training.blog.application.ArticleView;
import pl.training.blog.common.PageDefinition;
import pl.training.blog.common.ResultPage;
import pl.training.blog.domain.Article;
import pl.training.blog.domain.ArticleCategory;
import pl.training.blog.domain.Tag;
import pl.training.blog.ports.ArticleRepository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import static java.util.stream.Collectors.toSet;

@Repository
@RequiredArgsConstructor
public class SpringDataArticleRepositoryAdapter implements ArticleRepository {

    private final SpringDataArticleRepository articleRepository;
    private final SpringDataArticleRepositoryMapper articleMapper;

    @Override
    public Optional<Article> findById(UUID id) {
        return articleRepository.findById(id)
                .map(articleMapper::toDomain);
    }

    @Override
    public ResultPage<ArticleView> findByCategory(ArticleCategory category, PageDefinition pageDefinition) {
        var page = PageRequest.of(pageDefinition.pageNumber(), pageDefinition.pageSize());
        var resultPage = articleRepository.findByCategory(category.name(), page);
        return articleMapper.toDomain(resultPage);
    }

    @Override
    public ResultPage<ArticleView> findByTags(Set<Tag> tags, PageDefinition pageDefinition) {
        var page = PageRequest.of(pageDefinition.pageNumber(), pageDefinition.pageSize());
        var tagNames = tags.stream().map(Tag::getName).collect(toSet());
        var resultPage = articleRepository.findByTags(tagNames, tagNames.size(), page);
        return articleMapper.toDomain(resultPage);
    }

    @Override
    public ResultPage<ArticleView> findByCategoryAndTags(ArticleCategory category, Set<Tag> tags, PageDefinition pageDefinition) {
        var page = PageRequest.of(pageDefinition.pageNumber(), pageDefinition.pageSize());
        var tagNames = tags.stream().map(Tag::getName).collect(toSet());
        var resultPage = articleRepository.findByCategoryAndTags(category.name(), tagNames, tagNames.size(), page);
        return articleMapper.toDomain(resultPage);
    }

    @Override
    public Article save(Article article) {
        var articleEntity = articleMapper.toEntity(article);
        var savedArticleEntity = articleRepository.save(articleEntity);
        return articleMapper.toDomain(savedArticleEntity);
    }

    @Override
    public void deleteById(UUID articleId) {
        articleRepository.deleteById(articleId);
    }

}

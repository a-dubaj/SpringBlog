package pl.training.blog.adapters.rest;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import pl.training.blog.application.ArticleTemplate;
import pl.training.blog.application.ArticleView;
import pl.training.blog.common.ResultPage;
import pl.training.blog.domain.Article;
import pl.training.blog.domain.ArticleCategory;
import pl.training.blog.domain.ArticleUpdate;
import pl.training.blog.domain.Tag;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

@Mapper(componentModel = "spring")
public interface ArticleRestMapper {

    ArticleTemplate toDomain(ArticleTemplateDto articleTemplateDto);

    ArticleUpdate toDomain(ArticleUpdateDto articleUpdateDto);

    ArticleViewDto toDto(ArticleView articleView);

    ResultPage<ArticleViewDto> toDto(ResultPage<ArticleView> articleViewResultPage);

    default Tag toDomainTag(String tagName) {
        return new Tag(tagName);
    }

    default Set<Tag> toDomain(Set<String> tags) {
        if (tags == null) {
            return Collections.emptySet();
        }
        return tags.stream().map(Tag::new).collect(toSet());
    }

    ArticleCategory toDomainCategory(String category);

    ArticleDto toDto(Article article);

}

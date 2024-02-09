package pl.training.blog.adapters.persistence;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;
import pl.training.blog.application.ArticleView;
import pl.training.blog.common.ResultPage;
import pl.training.blog.domain.Article;

@Mapper(componentModel = "spring")
public interface SpringDataArticleRepositoryMapper {

    ArticleEntity toEntity(Article article);

    Article toDomain(ArticleEntity articleEntity);

    @Mapping(source = "content", target = "elements")
    @Mapping(source = "number", target = "pageNumber")
    ResultPage<ArticleView> toDomain(Page<ArticleView> articleViews);

}

package pl.training.blog.application;

import lombok.Value;
import pl.training.blog.domain.ArticleCategory;

@Value
public class ArticleTemplate {

    String title;
    String author;
    String content;
    ArticleCategory category;

}

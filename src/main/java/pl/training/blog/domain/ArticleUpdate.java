package pl.training.blog.domain;

import lombok.Data;
import pl.training.blog.domain.Tag;

import java.util.Set;

@Data
public class ArticleUpdate {

    private String title;
    private String content;
    private Set<Tag> tags;

}

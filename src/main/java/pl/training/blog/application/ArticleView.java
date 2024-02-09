package pl.training.blog.application;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@AllArgsConstructor
@Data
public class ArticleView {

    private UUID id;
    private String title;
    private String author;

}

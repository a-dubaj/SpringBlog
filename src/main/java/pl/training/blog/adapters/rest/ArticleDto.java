package pl.training.blog.adapters.rest;

import lombok.Data;

import java.time.Instant;

@Data
public class ArticleDto {

    private String title;
    private String author;
    private String content;
    private String category;
    private String status;
    private Instant created;
    private int likes;
    private int dislikes;

}

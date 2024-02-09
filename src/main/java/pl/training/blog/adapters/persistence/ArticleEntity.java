package pl.training.blog.adapters.persistence;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static jakarta.persistence.CascadeType.*;

@Table(name = "Articles", indexes = @Index(name = "article_category", columnList = "category"))
@Entity(name = "Article")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class ArticleEntity {

    @Id
    private UUID id;
    @Column(nullable = false, length = 200)
    private String title;
    private String author;
    @Lob
    @Column(length = 1024)
    private String content;
    private String category;
    private String status;
    @ManyToMany(cascade = {PERSIST, MERGE})
    private Set<TagEntity> tags;
    private Instant created;
    private Instant published;
    private int likes;
    private int dislikes;
    @JoinColumn(name = "article_id")
    @OneToMany(cascade = ALL)
    private List<CommentEntity> comments;

}

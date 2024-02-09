package pl.training.blog.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static java.util.Collections.emptySet;
import static lombok.AccessLevel.PRIVATE;
import static pl.training.blog.domain.ArticleStatus.DRAFT;
import static pl.training.blog.domain.ArticleStatus.PUBLISHED;

@Getter
@Builder
@AllArgsConstructor(access = PRIVATE)
public class Article {

    @Builder.Default
    private UUID id = UUID.randomUUID();
    private String title;
    private String author;
    private String content;
    private ArticleCategory category;
    @Builder.Default
    private ArticleStatus status = DRAFT;
    @Builder.Default
    private Set<Tag> tags = emptySet();
    @Builder.Default
    private Instant created = Instant.now();
    private Instant published;
    private int likes;
    private int dislikes;
    @Builder.Default
    private List<Comment> comments = new ArrayList<>();

    public void like() {
        likes++;
    }

    public void dislike() {
        dislikes++;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void publish() {
        if (status != PUBLISHED) {
            status = PUBLISHED;
            published = Instant.now();
        }
    }

    public void patch(ArticleUpdate articleUpdate) {
        var title = articleUpdate.getTitle();
        if (title != null) {
            this.title = title;
        }
        var content = articleUpdate.getContent();
        if (content != null) {
            this.content = content;
        }
        var tags = articleUpdate.getTags();
        if (tags != null && !tags.isEmpty()) {
            this.tags = tags;
        }
    }

}

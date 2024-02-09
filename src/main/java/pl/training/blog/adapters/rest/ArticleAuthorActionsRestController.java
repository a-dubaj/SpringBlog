package pl.training.blog.adapters.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.training.blog.application.ArticleAuthorActions;

import java.util.UUID;

@RequestMapping("articles")
@RestController
@RequiredArgsConstructor
public class ArticleAuthorActionsRestController {

    private final ArticleAuthorActions articleAuthorActions;
    private final ArticleRestMapper articleMapper;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody ArticleTemplateDto articleTemplateDto) {
        var articleTemplate = articleMapper.toDomain(articleTemplateDto);
        var articleId = articleAuthorActions.create(articleTemplate);
        var locationUri = LocationUri.fromRequest(articleId);
        return ResponseEntity.created(locationUri).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        articleAuthorActions.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("{id}")
    public ResponseEntity<Void> patch(@PathVariable UUID id, @RequestBody ArticleUpdateDto articleUpdateDto) {
        var articleUpdate = articleMapper.toDomain(articleUpdateDto);
        articleAuthorActions.update(id, articleUpdate);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("published/{id}")
    public ResponseEntity<Void> publish(@PathVariable UUID id) {
        articleAuthorActions.publish(id);
        return ResponseEntity.noContent().build();
    }

}

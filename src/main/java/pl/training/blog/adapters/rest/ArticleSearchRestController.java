package pl.training.blog.adapters.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.training.blog.application.ArticleSearch;
import pl.training.blog.common.PageDefinition;
import pl.training.blog.common.ResultPage;

import java.util.Set;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ArticleSearchRestController {

    private final ArticleSearch articleSearch;
    private final ArticleRestMapper articleMapper;

    @GetMapping("articles/{id}")
    public ResponseEntity<ArticleDto> findById(@PathVariable UUID id) {
        var article = articleSearch.findByUid(id);
        var articleDto = articleMapper.toDto(article);
        return ResponseEntity.ok(articleDto);
    }

    @GetMapping("categories/{categoryName}/articles")
    public ResponseEntity<ResultPage<ArticleViewDto>> findByCategory(
            @PathVariable String categoryName,
            @RequestParam(required = false, name = "tag") Set<String> tagNames,
            @RequestParam(required = false, defaultValue = "0") int pageNumber,
            @RequestParam(required = false, defaultValue = "10") int pageSize) {
        var category = articleMapper.toDomainCategory(categoryName);
        var tags = articleMapper.toDomain(tagNames);
        var resultPage = tags.isEmpty()
                ? articleSearch.findByCategory(category, new PageDefinition(pageNumber, pageSize))
                : articleSearch.findByCategoryAndTags(category, tags, new PageDefinition(pageNumber, pageSize));
        var resultPageDto = articleMapper.toDto(resultPage);
        return ResponseEntity.ok(resultPageDto);
    }

}

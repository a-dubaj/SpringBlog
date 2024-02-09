package pl.training.blog.adapters.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.training.blog.application.ArticleView;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface SpringDataArticleRepository extends JpaRepository<ArticleEntity, UUID> {

    @EntityGraph(attributePaths = {"tags", "comments"})
    @Override
    Optional<ArticleEntity> findById(UUID uuid);

    @Query("select new pl.training.blog.application.ArticleView(a.id, a.title, a.author) from Article a where a.category = :category")
    Page<ArticleView> findByCategory(String category, Pageable pageable);

    @Query("select new pl.training.blog.application.ArticleView(a.id, a.title, a.author) from Article a join a.tags at where at.name in :tags group by a having count (a) = :count")
    Page<ArticleView> findByTags(Set<String> tags, int count, Pageable pageable);

    @Query("select new pl.training.blog.application.ArticleView(a.id, a.title, a.author) from Article a join a.tags at where a.category = :category and at.name in :tags group by a having count (a) = :count")
    Page<ArticleView> findByCategoryAndTags(String category, Set<String> tags, int count, Pageable pageable);

}

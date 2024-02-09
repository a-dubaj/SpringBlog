package pl.training.blog;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.training.blog.application.ArticleAuthorActions;
import pl.training.blog.application.ArticleSearch;
import pl.training.blog.ports.ArticleRepository;

@Configuration
public class BlogConfiguration {

    @Bean
    public ArticleAuthorActions articleAuthorActions(ArticleRepository articleRepository) {
        return new ArticleAuthorActions(articleRepository);
    }

    @Bean
    public ArticleSearch articleSearch(ArticleRepository articleRepository) {
        return new ArticleSearch(articleRepository);
    }

}

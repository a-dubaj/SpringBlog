package pl.training.blog.adapters.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.training.blog.application.ArticleNotFoundException;

import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Order(HIGHEST_PRECEDENCE)
@ControllerAdvice("pl.training.blog.adapters.rest")
@RequiredArgsConstructor
public class PaymentRestExceptionHandler {

    @ExceptionHandler(ArticleNotFoundException.class)
    public ResponseEntity<ExceptionDto> onArticleNotFoundException(ArticleNotFoundException articleNotFoundException) {
        return ResponseEntity.status(NOT_FOUND)
                .body(new ExceptionDto("Article not found"));
    }

}

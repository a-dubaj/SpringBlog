package pl.training.blog.domain;

import java.time.Instant;

public record Comment(String text, Instant created, String author) {
}

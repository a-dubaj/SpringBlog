package pl.training.blog.adapters.rest;

import java.time.ZonedDateTime;

public record ExceptionDto(ZonedDateTime timestamp, String description) {

    public ExceptionDto(String description) {
        this(ZonedDateTime.now(), description);
    }

}

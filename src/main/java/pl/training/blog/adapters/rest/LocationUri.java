package pl.training.blog.adapters.rest;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class LocationUri {

    private static final String SEGMENT_SEPARATOR = "/";

    public static URI fromRequest(Object id) {
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path(SEGMENT_SEPARATOR + id)
                .build()
                .toUri();
    }

}

package pl.training.blog.common;

import lombok.Data;

import java.util.List;

@Data
public class ResultPage<E> {

    private List<E> elements;
    private int pageNumber;
    private int numberOfPages;

}

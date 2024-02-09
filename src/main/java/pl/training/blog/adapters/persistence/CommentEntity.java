package pl.training.blog.adapters.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Table(name = "Comments")
@Entity(name = "Comments")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class CommentEntity {

    @GeneratedValue
    @Id
    private Long id;
    private String text;
    private Instant created;
    private String author;

}

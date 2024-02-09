package pl.training.blog.adapters.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Table(name = "Tags")
@Entity(name = "Tags")
@Getter
@Setter
@EqualsAndHashCode(of = "name")
public class TagEntity {

    @Id
    private String name;

}

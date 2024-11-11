package eu.bilekpavel.vinotekalara.news.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
public final class News {

    @Id
    @GeneratedValue
    private int id;

    @Setter
    private String content;
}

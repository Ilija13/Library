package com.example.Library.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String title;
    @NotEmpty
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Author> author;
    @Enumerated(EnumType.STRING)
    @NotNull
    private Genre genre;

}

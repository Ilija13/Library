package com.example.Library.Entity;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "Author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authorid")
    private Long authorId;

    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @Past
    @NotNull
    private LocalDate dob;

    public Author() {

    }

}

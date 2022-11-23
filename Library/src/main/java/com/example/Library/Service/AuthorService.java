package com.example.Library.Service;
import com.example.Library.Entity.Author;
import java.util.List;

public interface AuthorService {
    Author AddAuthor(Author author);

    Author getAuthorById(Long id);

    List<Author> getAuthors();

    List<Object> mostPopular();
}

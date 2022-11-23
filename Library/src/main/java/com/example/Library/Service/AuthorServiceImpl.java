package com.example.Library.Service;
import com.example.Library.Entity.Author;
import com.example.Library.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author AddAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public List <Object> mostPopular() {
        return authorRepository.mostPopular();
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).get();
    }


}

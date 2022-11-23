package com.example.Library.Controller;
import com.example.Library.Entity.Author;
import com.example.Library.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController

public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/add-author")
    public Author addAuthor(@RequestBody Author author) {
        return authorService.AddAuthor(author);
    }

    @GetMapping("/get-authors")
    public List<Author> getAuthors() {
        return authorService.getAuthors();
    }

    @GetMapping("/get-authors/{id}")
    public Author getAuthorById(@PathVariable("id") Long id) {
        return authorService.getAuthorById(id);
    }

    //@Scheduled (cron = "0 0 9 * *") i didnt know how to set this methond to execute only when it is scheduled
    @GetMapping("/mostPopular")
    public List<Object> mostPopular() {
        return authorService.mostPopular();
    }

}

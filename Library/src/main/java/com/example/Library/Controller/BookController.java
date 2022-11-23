package com.example.Library.Controller;
import com.example.Library.Entity.Book;
import com.example.Library.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/get-books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("/add-book")
    public Book addBook(Book book) {
        return bookService.addBook(book);
    }

    @RequestMapping("/get-books/{id}")
    public Book getBookById(@PathVariable("id") Long id) {
        return bookService.getBookById(id);
    }

    @DeleteMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") Long bookId) {
        bookService.deleteById(bookId);
        return "Book deleted";
    }

    @PutMapping("/update-book/{id}")
    public Book updateBook(@PathVariable("id") Long id,
                           @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @GetMapping("/get-book/{title}")
    public Book getBookByTitle(@PathVariable("title") String bookTitle) {
        return bookService.getBookByTitle(bookTitle);
    }

    @GetMapping("/getbook/{title}")
    public Book findBookByTitleCase(@PathVariable("title") String bookTitle) {
        return bookService.findByTitleIgnoreCase(bookTitle);
    }

}

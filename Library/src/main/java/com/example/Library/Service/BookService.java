package com.example.Library.Service;
import com.example.Library.Entity.Book;
import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book addBook(Book book);

    Book getBookById(Long id);

    void deleteById(Long bookId);

    Book getBookByTitle(String bookName);

    Book findByTitleIgnoreCase(String bookTitle);

    Book updateBook(Long id, Book book);

}

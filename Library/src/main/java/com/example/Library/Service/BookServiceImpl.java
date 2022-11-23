package com.example.Library.Service;
import com.example.Library.Entity.Book;
import com.example.Library.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long bookId) {
        bookRepository.deleteById(bookId);
    }


    @Override
    public Book getBookByTitle(String bookTitle) {
        return bookRepository.findByTitle(bookTitle);
    }

    @Override
    public Book findByTitleIgnoreCase(String bookTitle) {
        return bookRepository.findByTitleIgnoreCase(bookTitle);
    }

    @Override
    public Book updateBook(Long id, Book book) {
        Book bookDb = bookRepository.findById(id).get();

        if (Objects.nonNull(book.getTitle()) && !"".equalsIgnoreCase(book.getTitle())) {
            bookDb.setTitle(book.getTitle());
        }
        if (!Objects.equals(book.getGenre(), bookDb.getGenre())) {
            bookDb.setGenre(book.getGenre());
        }
        if (!Objects.equals(book.getAuthor(), bookDb.getAuthor())) {
            bookDb.setAuthor(book.getAuthor());
        }
        return bookRepository.save(bookDb);
    }

}





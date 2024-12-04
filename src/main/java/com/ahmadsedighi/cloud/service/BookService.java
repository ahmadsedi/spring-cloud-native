package com.ahmadsedighi.cloud.service;

import com.ahmadsedighi.cloud.entity.Book;
import com.ahmadsedighi.cloud.exception.BookAlreadyExistsException;
import com.ahmadsedighi.cloud.exception.BookNotFoundException;
import com.ahmadsedighi.cloud.repository.BookRepository;
import org.springframework.stereotype.Service;

/**
 * @author Ahmad R. Seddighi (ahmadseddighi@yahoo.com)
 * Date: 03/12/2024
 * Time: 18:43
 */
@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> viewBookList() {
        return bookRepository.findAll();
    }

    public Book viewBookDetails(String isbn) {
        return bookRepository.findByIsbn(isbn)
                .orElseThrow(() -> new BookNotFoundException(isbn));
    }

    public Book addBookToCatalog(Book book) {
        if (bookRepository.existsByIsbn(book.getIsbn())) {
            throw new BookAlreadyExistsException(book.getIsbn());
        }
        return bookRepository.save(book);
    }

    public void removeBookFromCatalog(String isbn) {
        bookRepository.deleteByIsbn(isbn);
    }

    public Book editBookDetails(String isbn, Book book) {
        return bookRepository.findByIsbn(isbn)
                .map(existingBook -> {
                    var bookToUpdate = new Book(existingBook.getIsbn(),
                            book.getTitle(),
                            book.getAuthor(),
                            book.getPrice());
                    return bookRepository.save(bookToUpdate);
                })
                .orElseGet(() -> addBookToCatalog(book));
    }
}

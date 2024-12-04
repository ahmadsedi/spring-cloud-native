package com.ahmadsedighi.cloud.repository;

import com.ahmadsedighi.cloud.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Ahmad R. Seddighi (ahmadseddighi@yahoo.com)
 * Date: 03/12/2024
 * Time: 18:40
 */
@Repository
public class InMemoryBookRepository implements BookRepository {

    private static final Map<String, Book> books =
            new ConcurrentHashMap<>();

    @Override
    public Iterable<Book> findAll() {
        return books.values();
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        return existsByIsbn(isbn) ? Optional.of(books.get(isbn)) :
                Optional.empty();

    }

    @Override
    public boolean existsByIsbn(String isbn) {
        return books.get(isbn) != null;
    }

    @Override
    public Book save(Book book) {
        books.put(book.getIsbn(), book);
        return book;
    }
    @Override
    public void deleteByIsbn(String isbn) {
        books.remove(isbn);
    }

}

package com.ahmadsedighi.cloud.repository;

import java.util.Optional;

import com.ahmadsedighi.cloud.entity.Book;

/**
 * @author Ahmad R. Seddighi (ahmadseddighi@yahoo.com)
 * Date: 03/12/2024
 * Time: 18:31
 */

public interface BookRepository {
    Iterable<Book> findAll();
    Optional<Book> findByIsbn(String isbn);
    boolean existsByIsbn(String isbn);
    Book save(Book book);
    public void deleteByIsbn(String isbn);
}

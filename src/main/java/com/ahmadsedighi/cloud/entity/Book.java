package com.ahmadsedighi.cloud.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

/**
 * @author Ahmad R. Seddighi (ahmadseddighi@yahoo.com)
 * Date: 03/12/2024
 * Time: 18:19
 */

public class Book {

    @NotBlank(message = "The book ISBN must be defined.")
    @Pattern(
            regexp = "^([0-9]{10}|[0-9]{13})$",
            message = "The ISBN format must be valid."
    )
    String isbn;

    @NotBlank(
            message = "The book title must be defined."
    )
    String title;

    @NotBlank(message = "The book author must be defined.")
    String author;

    @NotNull(message = "The book price must be defined.")
    @Positive(
            message = "The book price must be greater than zero."
    )
    String price;

    public Book(String isbn, String title, String author, String price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

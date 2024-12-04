package com.ahmadsedighi.cloud;


import com.ahmadsedighi.cloud.entity.Book;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

/**
 * @author Ahmad R. Seddighi (ahmadseddighi@yahoo.com)
 * Date: 04/12/2024
 * Time: 12:52
 */

class BookValidationTests {
    private static Validator validator;


    @BeforeAll
    static void setUp(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void givenAllValidFields_successValidationExpected(){
        var book = new Book("1234567890", "Spring Book", "Ahmadreza Sedighi", "1.0");
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        assertThat(violations.isEmpty());
    }

    @Test
    void givenIncorrectIsbn_failedValidationExpected(){
        var book = new Book("a123456789", "Spring Book", "Ahmadreza Sedighi", "1.0");
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        assertThat(violations).hasSize(1);
        assertThat(violations.iterator().next().getMessage()).isEqualTo("The ISBN format must be valid.");
    }

}

package com.ahmadsedighi.cloud;

import com.ahmadsedighi.cloud.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;

@Import(TestcontainersConfiguration.class)
@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CloudNativeApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void postValidBook() {
		var book = new Book("1234567890", "Spring Book", "Ahmadreza Sedighi", "1.0");
		webTestClient.post().uri("/books").bodyValue(book).exchange().
				expectStatus().isCreated().
				expectBody(Book.class).value(actualBook -> {
					assertThat(actualBook).isNotNull();
					assertThat(actualBook.getIsbn()).isEqualTo(book.getIsbn());
		});
	}

}

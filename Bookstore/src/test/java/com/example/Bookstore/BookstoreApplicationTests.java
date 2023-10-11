package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Bookstore.web.BookstoreController;

@SpringBootTest
class BookstoreApplicationTests {
	
	@Autowired
	private BookstoreController controller;

	@Test
	void contextLoads() {
		 assertThat(controller).isNotNull();
	}

}

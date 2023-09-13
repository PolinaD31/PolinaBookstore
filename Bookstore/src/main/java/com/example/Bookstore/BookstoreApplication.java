package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.BookstoreRepository;
import com.example.Bookstore.model.Category;
import com.example.Bookstore.model.CategoryRepository;


@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	

	@Bean
	public CommandLineRunner demo(BookstoreRepository repository, CategoryRepository crepository) {
		return (args) -> {
			
			crepository.save(new Category("Non-fiction"));
			crepository.save(new Category("Fantasy"));
			
			Book b1 = new Book("A Farewell to Arms", "Ernest Hemignway", 1929, 1232323-21, 35, crepository.findByName("Non-fiction").get(0));
			Book b2 = new Book("Animal farm", "George Orwell", 1945, 2212343-5, 7, crepository.findByName("Fantasy").get(0));
			
			repository.save(b1);
			repository.save(b2);
		};
	}

}



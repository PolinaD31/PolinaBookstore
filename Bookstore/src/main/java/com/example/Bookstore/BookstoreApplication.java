package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.BookstoreRepository;
import com.example.Bookstore.model.Category;
import com.example.Bookstore.model.CategoryRepository;
import com.example.Bookstore.model.AppUser;
import com.example.Bookstore.model.AppUserRepository;


@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	

	@Bean
	public CommandLineRunner demo(BookstoreRepository repository, CategoryRepository crepository, AppUserRepository urepository) {
		return (args) -> {
			
			crepository.save(new Category("Non-fiction"));
			crepository.save(new Category("Fantasy"));
			
			Book b1 = new Book("A Farewell to Arms", "Ernest Hemignway", 1929, 1232323-21, 35, crepository.findByName("Non-fiction").get(0));
			Book b2 = new Book("Animal farm", "George Orwell", 1945, 2212343-5, 7, crepository.findByName("Fantasy").get(0));
			
			repository.save(b1);
			repository.save(b2);
			
			AppUser user1 = new AppUser("user", "$2a$10$bvx8qywnVqJ1j8/h5SuKDeM3rmYYHId77VkcsDjc6nLrnyhAaGPt2", "user@gmail.com", "USER");
			urepository.save(user1);
			AppUser user2 = new AppUser("admin", "$2a$10$shAN7QoJnrCGzYkwQoyl9.iXtCDnW8/muroY9xKcMMtO5cuS.3Kki", "admin@gmail.com", "ADMIN");
			urepository.save(user2);
		};
	}

}



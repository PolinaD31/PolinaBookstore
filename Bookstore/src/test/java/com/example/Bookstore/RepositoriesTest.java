package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Bookstore.model.AppUser;
import com.example.Bookstore.model.AppUserRepository;
import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.BookstoreRepository;
import com.example.Bookstore.model.Category;
import com.example.Bookstore.model.CategoryRepository;
import com.example.Bookstore.web.UserDetailServiceImpl;

@DataJpaTest
public class RepositoriesTest {
	@Autowired
	private BookstoreRepository repository;
	
	@Autowired
	private CategoryRepository crepository;

	@Autowired
	private AppUserRepository urepository;
	
	@Test
	public void findByIdGetsTheBook() {
		List<Book> books = repository.findById((long) 1);
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("Ernest Hemignway");
	}
	
	@Test
	public void bookCreate() {
		Category category = new Category("Fantasy");
		crepository.save(category);
		
		Book book = new Book("Animal farm", "George Orwell", 1945, 2212343-5, 7, crepository.findByName("Fantasy").get(0));
		repository.save(book);
		// when the book is saved, it gets assigned an ID, meaning it has been successfully saved
		assertThat(book.getId()).isNotNull();
	}
	
	@Test
	public void bookDelete() {
		repository.deleteById((long) 1);
		List<Book> books = (List<Book>) repository.findAll();
		assertThat(books).hasSize(1);
		
	}
	
	@Test
	public void categoryFindById() {
		List<Category> categories = crepository.findById((long) 1);
		assertThat(categories).hasSize(1);
		assertThat(categories.get(0).getName()).isEqualTo("Non-fiction");
	}
	
	@Test
	public void categoryCreate() {
		Category category = new Category("Biography");
		crepository.save(category);
		assertThat(category.getCategoryId()).isNotNull();
	}
	
	@Test
	public void categoryDelete() {
		crepository.deleteById((long) 1);
		List<Category> categories = (List<Category>) crepository.findAll();
		assertThat(categories).hasSize(1);
		
	}
	
	@Test
	public void findUserById() {
		List<AppUser> appUsers = urepository.findById((long) 1);
		assertThat(appUsers).hasSize(1);
		assertThat(appUsers.get(0).getUsername()).isEqualTo("user");
	}
	
	@Test
	public void userCreate() {
		AppUser appUser = new AppUser("user2", "$2a$10$bvx8qywnVqJ1j8/h5SuKDeM3rmYYHId77VkcsDjc6nLrnyhAaGPt2", "user@gmail.com", "USER");
		urepository.save(appUser);
		assertThat(appUser.getId()).isNotNull();
	}
	
	@Test
	public void userDelete() {
		urepository.deleteById((long) 1);
		List<AppUser> appUsers = (List<AppUser>) urepository.findAll();
		assertThat(appUsers).hasSize(1);
	}
	
}
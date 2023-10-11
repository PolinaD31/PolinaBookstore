package com.example.Bookstore.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface BookstoreRepository extends CrudRepository<Book, Long>{
	List<Book> findById(long id);
}

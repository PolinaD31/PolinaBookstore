package com.example.Bookstore.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {
	AppUser findByUsername(String username);
	
	List<AppUser> findById(long id);
}

// notes to self: this is a naming convention
// "findBy" tells spring that i want to retrieve something based on its value
// Username corresponds to property name in AppUser
// Spring will automatically generate a query 


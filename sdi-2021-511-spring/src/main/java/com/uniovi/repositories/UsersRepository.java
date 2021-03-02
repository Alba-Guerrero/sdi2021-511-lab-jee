package com.uniovi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.uniovi.entities.*;

public interface UsersRepository extends CrudRepository<User, Long>{
	User findByDni(String dni);
	
	
	@Query("SELECT r FROM User r WHERE (LOWER (r.name) Like LOWER (?1) OR LOWER(r.lastName)LIKE LOWER (?1)) ")
	List <User>   searchByDescriptionOrName(String searchtext);
	 



}

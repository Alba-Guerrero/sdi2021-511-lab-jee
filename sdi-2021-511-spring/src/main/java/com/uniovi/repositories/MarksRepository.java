package com.uniovi.repositories;
import org.springframework.data.repository.CrudRepository;

import com.uniovi.entities.Mark;
import com.uniovi.entities.User;

public interface MarksRepository  extends CrudRepository<Mark, Long>{
	 
}



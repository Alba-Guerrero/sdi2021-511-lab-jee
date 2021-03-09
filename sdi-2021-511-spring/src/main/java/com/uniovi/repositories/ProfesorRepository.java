package com.uniovi.repositories;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.uniovi.entities.Mark;
import com.uniovi.entities.Profesor;
import com.uniovi.entities.User;

public interface ProfesorRepository  extends CrudRepository<Profesor, Long>{
	
	Profesor findByDni(String dni);
	

	
}






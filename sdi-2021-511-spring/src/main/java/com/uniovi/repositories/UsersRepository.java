package com.uniovi.repositories;

import org.springframework.data.repository.CrudRepository;

import com.uniovi.entities.*;

public interface UsersRepository extends CrudRepository<User, Long>{

}

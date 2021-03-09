package com.uniovi.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Mark;
import com.uniovi.entities.Profesor;
import com.uniovi.entities.User;
import com.uniovi.repositories.ProfesorRepository;

@Service
public class ProfesorService {
	@Autowired
	private ProfesorRepository profesorRepository;


	public List<Profesor> getProfesores() {
		
		List<Profesor> profesores = new LinkedList<Profesor>();
		profesorRepository.findAll().forEach(profesores::add);
		System.err.println(profesorRepository.count());
		return profesores;
		
	}
	public Profesor getProfesorByDni(String dni) {
		return profesorRepository.findByDni(dni);
		}

	public Profesor getProfesor(Long id) {
		return profesorRepository.findById(id).get();
	}

	public void addProfesor(Profesor profesor) {
		
		profesorRepository.save(profesor);

	}
	
		

	public void deleteProfesor(Long id) {
		profesorRepository.deleteById(id);
	}

}
package com.uniovi.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Profesor;

@Service
public class ProfesorService {

	private List<Profesor> profesores = new LinkedList<Profesor>();

	@PostConstruct
	public void init() {
		profesores.add(new Profesor("584364789M", "Jane", "Doe", "Primaria"));
		profesores.add(new Profesor("11402879Y", "Peter", "Doe", "Infantil"));
	}

	public List<Profesor> getProfesores() {
		return profesores;
	}

	public Profesor getProfesor(Long id) {
		return profesores.stream().filter(profesor -> profesor.getId().equals(id)).findFirst().get();
	}

	public void addProfesor(Profesor profesor) {
		if (profesor.getId() != null) {
			profesor.setId(profesores.get(profesores.size() - 1).getId() + 1);
			profesores.add(profesor);
		}

	}

	public void deleteProfesor(String DNI) {
		profesores.removeIf(profesor -> profesor.getDNI().equals(DNI));
	}

}
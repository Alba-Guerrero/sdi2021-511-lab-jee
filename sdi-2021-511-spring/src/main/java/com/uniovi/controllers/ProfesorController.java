package com.uniovi.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uniovi.entities.Mark;
import com.uniovi.entities.Profesor;
import com.uniovi.service.MarksService;
import com.uniovi.service.ProfesorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class ProfesorController {
	@Autowired
	private ProfesorService profesorService;

	@RequestMapping("/profesor/list")
	public String getList() {
		return profesorService.getProfesores().toString();
	}

	@RequestMapping(value = "/profesor/add")
	public String addProfesor(@ModelAttribute Profesor profesor) {
		profesorService.addProfesor(new Profesor("584364789M", "Jane", "Doe", "Primaria"));
		profesorService.addProfesor(new Profesor("11402879Y", "Peter", "Doe", "Infantil"));
		return "Ok";
	}

	@RequestMapping("/profesor/details/{dni}")
	public String getDetail(@PathVariable Long id) {
		return profesorService.getProfesor(id).toString();
	}

	@RequestMapping(value = "/profesor/delete/{id}")
	public String deleteProfesor(@PathVariable Long id) {
		profesorService.deleteProfesor(id);
		return "Ok";
	}

}

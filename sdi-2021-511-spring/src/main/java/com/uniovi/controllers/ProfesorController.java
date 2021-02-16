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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfesorController {
	@Autowired
	private ProfesorService profesorService;

	@RequestMapping("/profesor/list")
	public String getList(Model model) {
		model.addAttribute("profesorList", profesorService.getProfesores());
		return "profesor/list";
	}

	@RequestMapping(value = "/profesor/add",method= RequestMethod.POST )
	public String addProfesor(@ModelAttribute Profesor profesor) {
		profesorService.addProfesor(profesor);
		return "redirect:/profesor/list";
	}

	@RequestMapping(value = "/profesor/add")
	public String getProfesor() {
		return "profesor/add";
	}

	@RequestMapping(value = "/profesor/delete/{id}")
	public String deleteProfesor(@PathVariable Long id) {
		profesorService.deleteProfesor(id);
		return "redirect:/profesor/list";
	}
	
	
	
	
	@RequestMapping(value="/profesor/edit/{id}")
	public String getEdit(Model model, @PathVariable Long id){
	model.addAttribute("mark", profesorService.getProfesor(id));
	return "mark/edit";
	}
	@RequestMapping(value="/profesor/edit/{id}", method=RequestMethod.POST)
	public String setEdit(Model model, @PathVariable Long id, @ModelAttribute Profesor profesor){
	profesor.setId(id);
	profesorService.addProfesor(profesor);
	return "redirect:/mark/details/"+id;
	}

}

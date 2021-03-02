package com.uniovi.controllers;

import com.uniovi.entities.Mark;
import com.uniovi.entities.Profesor;
import com.uniovi.service.MarksService;
import com.uniovi.service.ProfesorService;
import com.uniovi.validators.ProfesorValidator;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfesorController {
	@Autowired
	private ProfesorService profesorService;

	@Autowired
	private ProfesorValidator profesorValidator;

	@RequestMapping("/profesor/list")
	public String getList(Model model) {
		model.addAttribute("profesorList", profesorService.getProfesores());
		return "profesor/list";

	}

	@RequestMapping(value = "/profesor/add", method = RequestMethod.POST)
	public String addProfesor(@Validated Profesor profesor, BindingResult result) {
		profesorValidator.validate(profesor, result);
		if (result.hasErrors()) {

			return "profesor/add";
		}
		profesorService.addProfesor(profesor);
		return "redirect:/profesor/list";
	}

	@RequestMapping(value = "/profesor/add", method = RequestMethod.GET)
	public String addProfesor(Model model) {
		model.addAttribute("profesor", new Profesor());
		return "profesor/add";
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

	@RequestMapping("/profesor/details/{id}")
	public String getDetail(Model model, @PathVariable Long id) {
		model.addAttribute("profesor", profesorService.getProfesor(id));
		return "profesor/details";
	}

	@RequestMapping(value = "/profesor/edit/{id}")
	public String getEdit(Model model, @PathVariable Long id) {
		model.addAttribute("profesor", profesorService.getProfesor(id));
		return "profesor/edit";
	}

	@RequestMapping(value = "/profesor/edit/{id}", method = RequestMethod.POST)
	public String setEdit(Model model, @PathVariable Long id, @ModelAttribute Profesor profesor) {
		profesor.setId(id);
		profesorService.addProfesor(profesor);
		return "redirect:/profesor/details/" + id;

		// return "redirect:/profesor/list";
	}

}

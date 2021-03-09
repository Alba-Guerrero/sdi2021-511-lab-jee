package com.uniovi.validators;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.*;

import com.uniovi.entities.Mark;
import com.uniovi.entities.Profesor;
import com.uniovi.service.MarksService;
import com.uniovi.service.ProfesorService;

@Component
public class ProfesorValidator implements Validator {
	@Autowired
	private ProfesorService profesorService;

	@Override
	public boolean supports(Class<?> aClass) {
		return Mark.class.equals(aClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Profesor profesor = (Profesor) target;
		
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "score", "Error");
		
		if (profesor.getDni().length()!=9) {
			errors.rejectValue("dni", "Error.signup.dni.length");
		}
		if (!Character.isLetter(profesor.getDni().charAt(8))) {
			errors.rejectValue("dni", "Error.signup.dni.character");
		}
		if (profesorService.getProfesorByDni(profesor.getDni()) != null) {
			errors.rejectValue("dni", "Error.signup.dni.duplicate");
		}
		if (profesor.getNombre().length() < 5 || profesor.getNombre().length() > 24) {
			errors.rejectValue("nombre", "Error.signup.name.length");
		}
		if (profesor.getApellidos().length() < 5 || profesor.getApellidos().length() > 24) {
			errors.rejectValue("apellidos", "Error.signup.lastName.length");
		
		}
		if (profesor.getCategoria().length() < 5 || profesor.getCategoria().length() > 24) {
			errors.rejectValue("categoria", "Error.signup.categoria.length");
		
		}
		
	}
}
package com.uniovi.validators;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.*;

import com.uniovi.entities.Mark;
import com.uniovi.service.MarksService;

@Component
public class MarkValidator implements Validator {
	@Autowired
	private MarksService markservice;

	@Override
	public boolean supports(Class<?> aClass) {
		return Mark.class.equals(aClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Mark mark = (Mark) target;
		
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "score", "Error");
		
		if (mark.getScore() <= 0 || mark.getScore() >= 10 ) {
			errors.rejectValue("description", "Error.mark.score");
		}if(mark.getDescription().length() < 20 )
			errors.rejectValue("description", "Error.mark.description");

		
	}
}
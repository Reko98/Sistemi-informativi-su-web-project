package it.uniroma3.project.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.project.model.UseRequest;

public class UseRequestValidator  implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return UseRequest.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "This field is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "This field is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "This field is required");

	}

}

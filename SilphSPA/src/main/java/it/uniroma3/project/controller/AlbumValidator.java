package it.uniroma3.project.controller;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.project.model.Album;

@Component
public class AlbumValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Album.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Name", "This field is required");
	}

}

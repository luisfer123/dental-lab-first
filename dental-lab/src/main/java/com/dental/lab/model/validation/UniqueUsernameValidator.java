package com.dental.lab.model.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.dental.lab.services.UserService;

public class UniqueUsernameValidator
		implements ConstraintValidator<UniqueUsername, String> {
	
	@Autowired
	private UserService userService;

	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		
		if(userService == null)
			return true;
		
		return username != null
				&& !userService.existsByUsername(username);
	}

}

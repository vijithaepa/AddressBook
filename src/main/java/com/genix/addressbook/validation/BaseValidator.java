package com.genix.addressbook.validation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

public class BaseValidator<T>{
	private Validator validator;
	
	public BaseValidator() {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}
	
	public boolean validate(T entity) {
		Set<ConstraintViolation<T>> constraintResult = validator.validate(entity);
		
		return hasNoErrors(constraintResult);
	}
	
	private boolean hasNoErrors(Set<ConstraintViolation<T>> constraintResult) {
		return constraintResult.isEmpty();
	}
}

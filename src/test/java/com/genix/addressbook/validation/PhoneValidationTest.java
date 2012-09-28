package com.genix.addressbook.validation;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.genix.addressbook.entity.Phone;
import com.genix.addressbook.util.PhoneBuilder;

@Test
public class PhoneValidationTest {

	private PhoneValidator validator;

	@BeforeMethod
	public void beforeMethod() {
		validator = new PhoneValidator();
	}

	public void shouldReturnTrueGivenValidPhone() {
		boolean result = validator.validate(getValidPhone());
		assertTrue(result);

	}

	public void shouldReturnTrueGivenInvalidPhone() {
		boolean result = validator.validate(getInvalidPhone());
		assertFalse(result);
	}

	private Phone getValidPhone() {
		return PhoneBuilder.getPhoneBuilder().withNumber("444-223-2232").withType("Home").build();
	}

	private Phone getInvalidPhone() {
		return PhoneBuilder.getPhoneBuilder().withNumber("").withType("").build();
	}
}

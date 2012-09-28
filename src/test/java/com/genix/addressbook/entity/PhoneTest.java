package com.genix.addressbook.entity;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.genix.addressbook.AbstractTest;

@Test
public class PhoneTest extends AbstractTest {

	private static final long ID = 1;
	private Phone phone;

	@BeforeMethod
	public void beforeMethod() {
		phone = new Phone();
		phone.setId(ID);
	}

	public void shouldReturnIdGivenPhoneHasAId() {
		assertActualAndExpected(phone.getId(), ID);
	}

	public void shouldReturnNumberGivenPhoneHasANumber() {
		String expectedNumber = "012-4563-456";
		phone.setNumber(expectedNumber);
		assertActualAndExpected(phone.getNumber(), expectedNumber);
	}

	public void shouldReturnTypeGivenPhoneHasAType() {
		String expectedType = "HOME";
		phone.setType(expectedType);
		assertActualAndExpected(phone.getType(), expectedType);
	}

}

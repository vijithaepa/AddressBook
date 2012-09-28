package com.genix.addressbook.util;

import java.util.HashSet;
import java.util.Set;

import org.testng.annotations.Test;

import com.genix.addressbook.AbstractTest;
import com.genix.addressbook.entity.Person;
import com.genix.addressbook.entity.Phone;

@Test
public class PersonBuilderTest extends AbstractTest {

	public void shouldBuildPerosn() {
		Long expectedId = 2L;
		String expectedFName = "First Name";
		String expectedLName = "Last Name";
		Set<Phone> expectedPhoneNumbers = new HashSet<Phone>();
		expectedPhoneNumbers.add(PhoneBuilder.getPhoneBuilder().withId(1L).withNumber("123-456-55").withType("Home").build());
		expectedPhoneNumbers.add(PhoneBuilder.getPhoneBuilder().withId(2L).withNumber("723-456-33").withType("mobile").build());

		PersonBuilder personBuilder = PersonBuilder.getPersonBuiler().withId(expectedId).withFirstName(expectedFName)
		                .withLastName(expectedLName).withPhoneNumbers(expectedPhoneNumbers);
		Person person = personBuilder.build();
		assertActualAndExpected(expectedId, person.getId());
		assertActualAndExpected(expectedFName, person.getFirstName());
		assertActualAndExpected(expectedLName, person.getLastName());
		assertActualAndExpected(expectedPhoneNumbers.size(), person.getPhones().size());
	}
}

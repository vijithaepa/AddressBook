package com.genix.addressbook.manager.impl;

import static junit.framework.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.HashSet;
import java.util.Set;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.genix.addressbook.AbstractTest;
import com.genix.addressbook.dao.PersonDao;
import com.genix.addressbook.entity.Person;
import com.genix.addressbook.entity.Phone;
import com.genix.addressbook.manager.PersonManager;
import com.genix.addressbook.util.PersonBuilder;
import com.genix.addressbook.util.PhoneBuilder;

@Test
public class PersonManagerTest extends AbstractTest {

	@InjectMocks
	PersonManager personManager;

	@Mock
	PersonDao personDao;

	@BeforeMethod
	public void beforeMethod() {
		personManager = new PersonManagerImpl();
		initMocks(this);
	}

	public void shouldSaveSuccessfullyAGivenValidPerson() {
		// Given
		Person person = getTransientPerson();
		given(personDao.save(person)).willReturn(getPersistentPersonForCreate());

		// When
		Person savedPerson = personManager.create(person);
		// Then

		assertNotNull(savedPerson);
		assertNotNull(savedPerson.getId());
		assertActualAndExpected(person.getFirstName(), savedPerson.getFirstName());
		assertActualAndExpected(person.getLastName(), savedPerson.getLastName());
		assertActualAndExpected(person.getPhones().size(), savedPerson.getPhones().size());
	}

	public void shouldUpdateSuccessfullyAGivenValidPerson() {
		// Given
		Person person = getPersistentPerson();
		given(personDao.save(person)).willReturn(getUpdatedPerson());

		// When
		Person updatedPerson = personManager.update(person);
		// Then

		assertNotNull(updatedPerson);
		assertActualAndExpected(person.getFirstName(), updatedPerson.getFirstName());
		assertActualAndExpected(person.getLastName(), updatedPerson.getLastName());
		assertActualAndExpected(person.getPhones().size(), updatedPerson.getPhones().size());
	}

	public void shouldfindByFirstNameAndLastNameSuccessfullyAGivenValidPerson() {
		// Given
		Person person = getPersistentPerson();
		given(personDao.findByFirstNameAndLastName(person.getFirstName(), person.getLastName())).willReturn(getUpdatedPerson());

		// When
		Person retrievedPerson = personManager.findByFirstNameAndLastName(person.getFirstName(), person.getLastName());
		// Then

		assertNotNull(retrievedPerson);
		assertNotNull(retrievedPerson.getId());
		assertActualAndExpected(person.getFirstName(), retrievedPerson.getFirstName());
		assertActualAndExpected(person.getLastName(), retrievedPerson.getLastName());
		assertActualAndExpected(person.getPhones().size(), retrievedPerson.getPhones().size());
	}

	private Person getTransientPerson() {

		Set<Phone> phoneList = new HashSet<Phone>();
		phoneList.add(PhoneBuilder.getPhoneBuilder().withId(1L).withNumber("000-1111-222").build());
		phoneList.add(PhoneBuilder.getPhoneBuilder().withId(1L).withNumber("000-1111-222").build());
		return PersonBuilder.getPersonBuiler().withFirstName("First Name 1").withLastName("Last Name 1").withPhoneNumbers(phoneList)
		                .build();
	}

	private Person getPersistentPersonForCreate() {
		Set<Phone> phoneList = new HashSet<Phone>();
		phoneList.add(PhoneBuilder.getPhoneBuilder().withId(1L).withNumber("000-1111-222").build());
		phoneList.add(PhoneBuilder.getPhoneBuilder().withId(1L).withNumber("000-1111-222").build());
		return PersonBuilder.getPersonBuiler().withId(1L).withFirstName("First Name 1").withLastName("Last Name 1")
		                .withPhoneNumbers(phoneList).build();
	}

	private Person getPersistentPerson() {
		Set<Phone> phoneList = new HashSet<Phone>();
		phoneList.add(PhoneBuilder.getPhoneBuilder().withId(1L).withNumber("999-1111-222").build());
		phoneList.add(PhoneBuilder.getPhoneBuilder().withId(1L).withNumber("999-1111-222").build());
		return PersonBuilder.getPersonBuiler().withId(1L).withFirstName("First Name Update").withLastName("Last Name Update")
		                .withPhoneNumbers(phoneList).build();
	}

	private Person getUpdatedPerson() {
		Set<Phone> phoneList = new HashSet<Phone>();
		phoneList.add(PhoneBuilder.getPhoneBuilder().withId(1L).withNumber("999-1111-222").build());
		phoneList.add(PhoneBuilder.getPhoneBuilder().withId(1L).withNumber("999-1111-222").build());
		return PersonBuilder.getPersonBuiler().withId(1L).withFirstName("First Name Update").withLastName("Last Name Update")
		                .withPhoneNumbers(phoneList).build();
	}
}

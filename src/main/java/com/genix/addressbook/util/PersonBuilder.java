package com.genix.addressbook.util;

import java.util.HashSet;
import java.util.Set;

import com.genix.addressbook.entity.Person;
import com.genix.addressbook.entity.Phone;

/**
 * 
 * @author Vijitha Epa.
 * @since 26-09-12.
 * 
 * Builder tool to build an instance of {@link Person}.
 */
public class PersonBuilder implements Builder<Person> {

	long id;
	private String firstName;
	private String lastName;
	private String street;
	private String suburb;
	private String state;
	private String postCode;
	private Set<Phone> phones = new HashSet<Phone>();

	private PersonBuilder(){}
	
	public static PersonBuilder getPersonBuiler() {
		return new PersonBuilder();
	}

	public PersonBuilder withId(long expectedId) {
		this.id = expectedId;
		return this;
	}

	public PersonBuilder withFirstName(String string) {
		this.firstName = string;
		return this;
	}

	public PersonBuilder withLastName(String string) {
		this.lastName = string;
		return this;
	}

	public PersonBuilder withPhoneNumbers(Set<Phone> list) {
		this.phones = list;
		return this;
	}

	public PersonBuilder withStreet(String string) {
		this.street = string;
		return this;
	}

	public PersonBuilder withSuburb(String string) {
		this.suburb = string;
		return this;
	}

	public PersonBuilder withState(String string) {
		this.state = string;
		return this;
	}

	public PersonBuilder withPostCode(String string) {
		this.postCode = string;
		return this;
	}

	@Override
	public Person build() {
		Person person = new Person();
		person.setId(id);
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setStreet(street);
		person.setSuburb(suburb);
		person.setState(state);
		person.setPostCode(postCode);
		person.setPhones(phones);
		return person;
	}

}

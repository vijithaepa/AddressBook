package com.genix.addressbook.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * 
 * @author Vijitha Epa.
 * @since 26-09-12.
 * 
 * Holds {@link Person} attributes.
 */
@Entity
@Table(name = "PERSON")
public class Person {
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;
	@Column(name = "firstName")
	private String firstName;
	@Column(name = "lastName")
	private String lastName;
	@Column(name = "street")
	private String street;
	@Column(name = "suburb")
	private String suburb;
	@Column(name = "state")
	private String state;
	@Column(name = "postCode")
	private String postCode;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "PERSON_ID", nullable = false)
	private Set<Phone> phones = new HashSet<Phone>();

	public void addPhone(Phone phone) {
		if (!getPhones().contains(phone)) {
			getPhones().add(phone);
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getSuburb() {
		return suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public Set<Phone> getPhones() {
		return phones;
	}

	public void setPhones(Set<Phone> phones) {
		this.phones = phones;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Person person = (Person) o;

		if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null)
			return false;
		if (id != null ? !id.equals(person.id) : person.id != null)
			return false;
		if (lastName != null ? !lastName.equals(person.lastName) : person.lastName != null)
			return false;
		if (phones != null ? !phones.equals(person.phones) : person.phones != null)
			return false;
		if (postCode != null ? !postCode.equals(person.postCode) : person.postCode != null)
			return false;
		if (state != null ? !state.equals(person.state) : person.state != null)
			return false;
		if (street != null ? !street.equals(person.street) : person.street != null)
			return false;
		if (suburb != null ? !suburb.equals(person.suburb) : person.suburb != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
		result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
		result = 31 * result + (street != null ? street.hashCode() : 0);
		result = 31 * result + (suburb != null ? suburb.hashCode() : 0);
		result = 31 * result + (state != null ? state.hashCode() : 0);
		result = 31 * result + (postCode != null ? postCode.hashCode() : 0);
		result = 31 * result + (phones != null ? phones.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Person{" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", street='" + street
		                + '\'' + ", suburb='" + suburb + '\'' + ", state='" + state + '\'' + ", postCode='" + postCode + '\'' + ", phones="
		                + phones + '}';
	}
}

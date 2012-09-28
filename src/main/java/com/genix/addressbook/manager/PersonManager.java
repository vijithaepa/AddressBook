package com.genix.addressbook.manager;

import com.genix.addressbook.entity.Person;

/**
 * 
 * @author Vijitha Epa.
 * @since 26-09-12.
 * 
 */
public interface PersonManager extends EntityManager<Person>{

	/**
	 * Returns the {@link Person} type instance by the parameter firstName and lastName.
	 * @param furstName as fetching criteria.
	 * @param lastName as fetching criteria.
	 * @return {@link Person} instance of results.
	 */
	Person findByFirstNameAndLastName(String furstName, String lastName);
}

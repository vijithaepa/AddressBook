package com.genix.addressbook.dao;

import com.genix.addressbook.entity.Person;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 
 * @author Vijitha Epa.
 * @since 26-09-12.
 * 
 * Data access operations related to {@link Person}.
 */
public interface PersonDao extends CrudRepository<Person, Long> {

    List<Person> findByLastName(String lastName);

    List<Person> findByFirstName(String firstName);
    
    /**
	 * Returns the {@link Person} type instance by the parameter firstName and lastName.
	 * @param furstName as fetching criteria.
	 * @param lastName as fetching criteria.
	 * @return {@link Person} instance of results.
	 */
    @Query("From Person p where p.firstName = :firstName and p.lastName = :lastName")
    Person findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName")String lastName);
}

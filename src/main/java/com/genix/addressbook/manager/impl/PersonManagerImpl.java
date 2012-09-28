package com.genix.addressbook.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.genix.addressbook.dao.PersonDao;
import com.genix.addressbook.entity.Person;
import com.genix.addressbook.exception.ValidationFailException;
import com.genix.addressbook.manager.PersonManager;

public class PersonManagerImpl implements PersonManager {

	@Autowired
	PersonDao personDao;

	@Override
	public Person create(Person entity) {
		Person persistPerson = personDao.findByFirstNameAndLastName(entity.getFirstName(), entity.getLastName());
		if (persistPerson != null && persistPerson.getId() > -1) {
			entity.setId(persistPerson.getId());
		}
		return personDao.save(entity);
	}

	@Override
	public Person update(Person entity) {
		return personDao.save(entity);
	}

	@Override
	public Person delete(Person entity) {
		Person toBeDeltedPerson = personDao.findByFirstNameAndLastName(entity.getFirstName(), entity.getLastName());
		if (toBeDeltedPerson != null && toBeDeltedPerson.getId() > -1) {
			personDao.delete(toBeDeltedPerson);
		} else {
			throw new ValidationFailException("No Such a person to Delete....");
		}
		if (toBeDeltedPerson != null && personDao.exists(toBeDeltedPerson.getId()))
			return entity;
		return null;
	}

	@Override
	public Person get(Long entityId) {
		return personDao.findOne(entityId);
	}

	@Override
	public Person findByFirstNameAndLastName(String firstName, String lastName) {
		return personDao.findByFirstNameAndLastName(firstName, lastName);
	}

}

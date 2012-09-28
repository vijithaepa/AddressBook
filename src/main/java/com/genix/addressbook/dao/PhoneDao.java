package com.genix.addressbook.dao;

import org.springframework.data.repository.CrudRepository;

import com.genix.addressbook.entity.Phone;

/**
 * 
 * @author Vijitha Epa.
 * @since 26-09-12.
 * 
 * Data access operations related to {@link Phone}.
 */
public interface PhoneDao extends CrudRepository<Phone, Long> {

}

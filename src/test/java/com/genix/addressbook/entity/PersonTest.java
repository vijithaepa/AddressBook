package com.genix.addressbook.entity;

import com.genix.addressbook.AbstractTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class PersonTest extends AbstractTest{

    private static final long ID = 1;
    private Person person;


    @BeforeMethod
    public void beforeMethod() {
      person = new Person();
      person.setId(ID);
    }

    public void shouldReturnIdGivenPersonHasAId() {
        assertActualAndExpected(person.getId(), ID);
    }

    public void shouldAddPhoneGivenPersonHasNoContacts() {
        Phone mobile = new Phone();
        person.addPhone(mobile);
        assertActualAndExpected(person.getPhones().size(), 1);
    }


}

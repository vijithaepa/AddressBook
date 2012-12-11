package com.genix.addressbook.util;

import org.testng.annotations.Test;

import com.genix.addressbook.AbstractTest;
import com.genix.addressbook.manager.impl.PersonManagerImpl;

//@Test
public class ResourceLocatorTest extends AbstractTest {

	public void shourldResturnAValidBeanForAGivenBeanName() {
		Class expectedType = PersonManagerImpl.class;
		Object object = ResourceLocator.getBean("personManager");
		Class actualType = object.getClass();
		assertActualAndExpected(actualType, expectedType);
	}

	public void shouldReturnAValidMessageForAGivenKey() {
		String expectedMessage = "Test Is successfull";
		String actualMessage = ResourceLocator.getI18NMessage("testMessage");
		assertActualAndExpected(actualMessage, expectedMessage);

	}

}

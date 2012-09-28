package com.genix.addressbook.util;

import com.genix.addressbook.AbstractTest;
import com.genix.addressbook.entity.Phone;
import org.testng.annotations.Test;


@Test
public class PhoneBuilderTest extends AbstractTest {

    public void shouldBuildPhoneInstance() {
        Long id = 1L;
        String expectedNumber = "112";
        String expectedType = "Home";
        PhoneBuilder builder = PhoneBuilder.getPhoneBuilder().withId(id).withNumber(expectedNumber).withType(expectedType);
        Phone p = builder.build();

        assertActualAndExpected(id, p.getId());
        assertActualAndExpected(expectedNumber, p.getNumber());
        assertActualAndExpected(expectedType, p.getType());

    }
}

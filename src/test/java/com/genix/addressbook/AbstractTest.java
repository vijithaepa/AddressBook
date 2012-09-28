package com.genix.addressbook;

import static org.testng.Assert.assertEquals;


public abstract  class AbstractTest {
    public final <T> void assertActualAndExpected(T actual, T expected) {
        assertEquals(actual, expected);
    }
}

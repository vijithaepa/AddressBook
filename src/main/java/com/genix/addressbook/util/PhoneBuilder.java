package com.genix.addressbook.util;


import com.genix.addressbook.entity.Phone;

/**
 * 
 * @author Vijitha Epa.
 * @since 26-09-12.
 * 
 * Builder tool to build an instance of {@link Phone}.
 */
public class PhoneBuilder implements Builder<Phone> {

    private long id;

    private String number;

    private String type;

    private PhoneBuilder() {}

    public static PhoneBuilder  getPhoneBuilder() {
       return new PhoneBuilder();
    }

    public PhoneBuilder withId(long id)       {
        this.id = id;
        return this;
    }

    public PhoneBuilder withNumber(String number)       {
        this.number = number;
        return this;
    }

    public PhoneBuilder withType(String type)       {
        this.type = type;
        return this;
    }


    public Phone build() {
        Phone p = new Phone();
        p.setId(id);
        p.setNumber(number);
        p.setType(type);

        return p;
    }
}

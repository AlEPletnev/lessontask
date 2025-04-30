package org.taskThree;

import java.util.Objects;

public class Phone {

    private final String number;

    private final PhoneType phoneType;

    public Phone(String number, PhoneType phoneType) {
        this.number = number;
        this.phoneType = phoneType;
    }

    public String getNumber() {
        return number;
    }

    public PhoneType getPhoneType() {
        return phoneType;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return Objects.equals(number, phone.number) && phoneType == phone.phoneType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, phoneType);
    }
}

package org.taskThree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client {

    private final int id;

    private final String name;

    private final int age;

    private PhoneType phoneType;

    private List<Phone> phoneList;

    public Client(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void addPhone(Phone phone){
        if(phone != null){
            phoneList.add(phone);
        }
    }

    public void addPhone(List<Phone> phoneList){
        if(phoneList != null){
            for(Phone phone : phoneList){
                addPhone(phone);
            }
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public PhoneType getPhoneType() {
        return phoneType;
    }

    public List<Phone> getPhoneList() {
        return new ArrayList<>(phoneList);
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id && age == client.age && Objects.equals(name, client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phoneList=" + phoneList +
                '}';
    }
}

package com.bubnii.entity;

import com.bubnii.enums.PersonType;

import java.util.Objects;

public class Person {
    private int idPerson;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private PersonType personType;

    public Person() {
    }

    public Person(int idPerson, String username, String password, String firstName, String lastName, PersonType personType) {
        this.idPerson = idPerson;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.personType = personType;
    }

    public Person(String username, String password, String firstName, String lastName, PersonType personType) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.personType = personType;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Person))
            return false;

        Person person = (Person) o;

        return idPerson == person.idPerson
                && username.equals(person.username)
                && password.equals(person.password)
                && firstName.equals(person.firstName)
                && lastName.equals(person.lastName)
                && personType == person.personType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPerson, username, password, firstName, lastName, personType);
    }

    @Override
    public String toString() {
        return "Person [" +
                "idPerson=" + idPerson +
                ", username=" + username +
                ", password=" + password +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ", personType=" + personType +
                ']';
    }
}

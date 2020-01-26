package com.bubnii.service.interfaces;

import com.bubnii.entity.Person;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public interface PersonService {

    List<Person> getAll() throws SQLException, NamingException;

    boolean add(Person person) throws SQLException, NamingException; // C

    Person get(int id) throws SQLException, NamingException; // R

    boolean update(Person person) throws SQLException, NamingException; // U

    boolean delete(int id) throws SQLException, NamingException; // D

    Person getPersonByCredentials(String username) throws SQLException, NamingException;
}

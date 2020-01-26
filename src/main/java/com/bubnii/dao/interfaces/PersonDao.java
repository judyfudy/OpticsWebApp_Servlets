package com.bubnii.dao.interfaces;

import com.bubnii.entity.Person;

import javax.naming.NamingException;
import java.sql.SQLException;

public interface PersonDao extends Dao<Person> {
    Person getPersonByCredentials(String username) throws SQLException, NamingException;
}

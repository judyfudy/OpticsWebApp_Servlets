package com.bubnii.service.implementations;

import com.bubnii.dao.implementations.PersonDaoImpl;
import com.bubnii.dao.interfaces.PersonDao;
import com.bubnii.entity.Person;
import com.bubnii.service.interfaces.PersonService;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public class PersonServiceImpl implements PersonService {
    private final PersonDao personDao = new PersonDaoImpl();

    @Override
    public List<Person> getAll() throws SQLException, NamingException {

        return personDao.getAll();
    }

    @Override
    public boolean add(Person person) throws SQLException, NamingException {

        return personDao.add(person);
    }

    @Override
    public Person get(int id) throws SQLException, NamingException {

        return personDao.get(id);
    }

    @Override
    public boolean update(Person person) throws SQLException, NamingException {

        return personDao.update(person);
    }

    @Override
    public boolean delete(int id) throws SQLException, NamingException {

        return personDao.delete(id);
    }

    public Person getPersonByCredentials(String username)
            throws SQLException, NamingException {

        return personDao.getPersonByCredentials(username);
    }
}

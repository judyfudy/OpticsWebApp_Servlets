package com.bubnii.dao.implementations;

import com.bubnii.config.DBConnection;
import com.bubnii.dao.interfaces.PersonDao;
import com.bubnii.entity.Person;
import com.bubnii.enums.PersonType;

import javax.naming.NamingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoImpl implements PersonDao {
    @Override
    public Person getPersonByCredentials(String username) throws SQLException, NamingException {
        Person person = new Person();

        String sql = "SELECT * FROM person WHERE person.username = ?";

        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            person.setIdPerson(rs.getInt("id"));
            person.setUsername(rs.getString("username"));
            person.setPassword(rs.getString("pass"));
            person.setFirstName(rs.getString("first_name"));
            person.setLastName(rs.getString("last_name"));
            person.setEmail(rs.getString("email"));
            person.setPersonType(PersonType.USER);
        }
        ps.close();

        return person;
    }

    @Override
    public List<Person> getAll() {
        ArrayList<Person> personList = new ArrayList<>();

        String sql = "SELECT * FROM person";

        try (Statement statement = DBConnection.getConnection().createStatement()) {
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                Person person = new Person();
                person.setIdPerson(rs.getInt("id"));
                person.setUsername(rs.getString("username"));
                person.setPassword(rs.getString("pass"));
                person.setFirstName(rs.getString("first_name"));
                person.setLastName(rs.getString("last_name"));
                person.setEmail(rs.getString("email"));
                person.setPersonType(PersonType.valueOf(rs.getString("person_type")));

                personList.add(person);
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return personList;
    }

    @Override
    public boolean add(Person person) throws SQLException, NamingException {
        String sql = "INSERT INTO person(username, pass, first_name, last_name, email, person_type)"
                + "VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setString(1, person.getUsername());
        ps.setString(2, person.getPassword());
        ps.setString(3, person.getFirstName());
        ps.setString(4, person.getLastName());
        ps.setString(5, person.getEmail());
        ps.setString(6, "user");

        boolean isAdded = ps.executeUpdate() > 0;
        ps.close();

        return isAdded;

    }

    @Override
    public Person get(int id) throws SQLException, NamingException {
        Person person = new Person();

        String sql = "SELECT * FROM person WHERE person.id = ?";

        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            person.setIdPerson(rs.getInt("id"));
            person.setUsername(rs.getString("username"));
            person.setPassword(rs.getString("pass"));
            person.setFirstName(rs.getString("first_name"));
            person.setLastName(rs.getString("last_name"));
            person.setEmail(rs.getString("email"));
            person.setPersonType(PersonType.USER);
        }
        ps.close();

        return person;
    }

    @Override
    public boolean update(Person person) throws SQLException, NamingException {
        String sql = "UPDATE person SET first_name=?, last_name=? WHERE id=?";

        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setString(1, person.getFirstName());
        ps.setString(2, person.getLastName());
        ps.setInt(3, person.getIdPerson());

        boolean isUpdated = ps.execute();
        ps.close();

        return isUpdated;
    }

    @Override
    public boolean delete(int id) throws SQLException, NamingException {

        String sql = "DELETE FROM person WHERE id=?";

        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setInt(1, id);

        boolean isDeleted = ps.execute();
        ps.close();

        return isDeleted;
    }

}

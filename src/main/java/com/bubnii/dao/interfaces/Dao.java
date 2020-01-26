package com.bubnii.dao.interfaces;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {
    List<T> getAll();

    boolean add(T t) throws SQLException, NamingException; // C

    T get(int id) throws SQLException, NamingException; // R

    boolean update(T t) throws SQLException, NamingException; // U

    boolean delete(int id) throws SQLException, NamingException; // D
}

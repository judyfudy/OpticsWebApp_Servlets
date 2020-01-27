package com.bubnii.dao.implementations;

import com.bubnii.config.DBConnection;
import com.bubnii.dao.interfaces.LensesDao;
import com.bubnii.entity.Glasses;
import com.bubnii.entity.Lenses;

import javax.naming.NamingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class LensesDaoImpl implements LensesDao {
    @Override
    public List<Lenses> getAll() {

        List<Lenses> lenses = new LinkedList<>();


        String sql = "SELECT * FROM lenses";

        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Lenses lense = new Lenses();
                lense.setId(rs.getInt("id"));
                lense.setPrice(rs.getInt("price"));
                lense.setDiameter(rs.getLong("diameter"));
                lense.setBrand(rs.getString("brand"));
                lense.setAppointment(rs.getString("appointment"));
                lense.setImage(rs.getString("image"));
                lenses.add(lense);
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }

        return lenses;
    }

    @Override
    public boolean add(Lenses glasses) throws SQLException, NamingException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Lenses get(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean update(Lenses glasses) throws SQLException, NamingException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException();
    }
}

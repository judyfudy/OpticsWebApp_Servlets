package com.bubnii.dao.implementations;

import com.bubnii.config.DBConnection;
import com.bubnii.dao.interfaces.GlassesDao;
import com.bubnii.entity.Glasses;
import com.bubnii.entity.Worker;

import javax.naming.NamingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class GlassesDaoImpl implements GlassesDao {
    @Override
    public List<Glasses> getAll() {

        List<Glasses> glasses = new LinkedList<>();


        String sql = "SELECT * FROM glasses";

        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Glasses glass = new Glasses();
                glass.setId(rs.getInt("id"));
                glass.setPrice(rs.getInt("price"));
                glass.setType(rs.getString("type"));
                glass.setForm(rs.getString("form"));
                glass.setSex(rs.getString("sex"));
                glass.setMaterial(rs.getString("material"));
                glass.setBrand(rs.getString("brand"));
                glass.setImage(rs.getString("image"));
                glasses.add(glass);
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }

        return glasses;
    }

    @Override
    public boolean add(Glasses glasses) throws SQLException, NamingException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Glasses get(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean update(Glasses glasses) throws SQLException, NamingException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException();
    }
}

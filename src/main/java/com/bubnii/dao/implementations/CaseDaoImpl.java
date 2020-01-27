package com.bubnii.dao.implementations;

import com.bubnii.config.DBConnection;
import com.bubnii.dao.interfaces.CaseDao;
import com.bubnii.entity.Case;

import javax.naming.NamingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CaseDaoImpl implements CaseDao {
    @Override
    public List<Case> getAll() {

        List<Case> cases = new LinkedList<>();


        String sql = "SELECT * FROM cases";

        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Case optic_case = new Case();
                optic_case.setId(rs.getInt("id"));
                optic_case.setPrice(rs.getInt("price"));
                optic_case.setBrand(rs.getString("brand"));
                optic_case.setColor(rs.getString("color"));
                optic_case.setImage(rs.getString("image"));
                cases.add(optic_case);
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }

        return cases;
    }

    @Override
    public boolean add(Case cases) throws SQLException, NamingException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Case get(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean update(Case cases) throws SQLException, NamingException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException();
    }
}

package com.bubnii.dao.implementations;

import com.bubnii.config.DBConnection;
import com.bubnii.dao.interfaces.WorkerDao;
import com.bubnii.entity.Worker;

import javax.naming.NamingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class WorkerDaoImpl implements WorkerDao {
    @Override
    public List<Worker> getAll() {

        List<Worker> workers = new LinkedList<>();


        String sql = "SELECT * FROM worker";

        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Worker worker = new Worker();
                worker.setId(rs.getInt("id"));
                worker.setAge(rs.getInt("age"));
                worker.setExperience(rs.getInt("experience"));
                worker.setFirstName(rs.getString("first_name"));
                worker.setLastName(rs.getString("last_name"));
                worker.setMiddleName(rs.getString("middle_name"));
                worker.setPhoto(rs.getString("photo_url"));
                workers.add(worker);
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }

        return workers;
    }

    @Override
    public boolean add(Worker worker) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Worker get(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean update(Worker worker) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException();
    }
}

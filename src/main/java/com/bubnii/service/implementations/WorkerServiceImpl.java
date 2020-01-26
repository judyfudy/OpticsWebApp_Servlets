package com.bubnii.service.implementations;

import com.bubnii.dao.implementations.WorkerDaoImpl;
import com.bubnii.dao.interfaces.WorkerDao;
import com.bubnii.entity.Worker;
import com.bubnii.service.interfaces.WorkerService;

import java.util.List;

public class WorkerServiceImpl implements WorkerService {
    private final WorkerDao workerDao = new WorkerDaoImpl();

    @Override
    public List<Worker> getAll() {
        return workerDao.getAll();
    }
}

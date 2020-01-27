package com.bubnii.service.implementations;

import com.bubnii.dao.implementations.LensesDaoImpl;
import com.bubnii.dao.interfaces.LensesDao;
import com.bubnii.entity.Lenses;
import com.bubnii.service.interfaces.LensesService;

import java.util.List;

public class LensesServiceImpl implements LensesService {
    private final LensesDao lensesDao = new LensesDaoImpl();

    @Override
    public List<Lenses> getAll() {
        return null;
    }
}

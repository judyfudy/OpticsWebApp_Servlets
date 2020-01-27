package com.bubnii.service.implementations;

import com.bubnii.dao.implementations.GlassesDaoImpl;
import com.bubnii.dao.interfaces.GlassesDao;
import com.bubnii.entity.Glasses;
import com.bubnii.service.interfaces.GlassesService;

import java.util.List;

public class GlassesServiceImpl implements GlassesService {
    private final GlassesDao glassesDao = new GlassesDaoImpl();
    @Override
    public List<Glasses> getAll() {
        return glassesDao.getAll();
    }
}

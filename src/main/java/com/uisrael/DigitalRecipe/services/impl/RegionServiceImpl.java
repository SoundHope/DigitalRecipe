package com.uisrael.DigitalRecipe.services.impl;

import com.uisrael.DigitalRecipe.model.Region;
import com.uisrael.DigitalRecipe.repository.IRegionRepository;
import com.uisrael.DigitalRecipe.services.IRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImpl implements IRegionService {

    @Autowired
    private IRegionRepository repo;
    @Override
    public List<Region> getAll() {
        return repo.findAll();
    }

    @Override
    public void save(Region object) {
        repo.save(object);
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }

    @Override
    public Region getById(int id) {
        return repo.findById(id).get();
    }
}

package com.uisrael.DigitalRecipe.services.impl;

import com.uisrael.DigitalRecipe.model.Store;
import com.uisrael.DigitalRecipe.repository.IStoreRepository;
import com.uisrael.DigitalRecipe.services.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements IStoreService {

    @Autowired
    private IStoreRepository repo;

    @Override
    public List<Store> getAll() {
        return repo.findAll();
    }

    @Override
    public void save(Store object) {
        repo.save(object);
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }

    @Override
    public Store getById(int id) {
        return repo.findById(id).get();
    }
}

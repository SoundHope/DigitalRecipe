package com.uisrael.DigitalRecipe.services;

import com.uisrael.DigitalRecipe.model.Store;

import java.util.List;

public interface IStoreService {
    List<Store> getAll();
    void save(Store object);
    void deleteById(int id);
    Store getById(int id);
}

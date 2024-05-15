package com.uisrael.DigitalRecipe.services;

import com.uisrael.DigitalRecipe.model.Region;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IRegionService {
    List<Region> getAll();
    void save(Region object);
    void deleteById(int id);
    Region getById(int id);
}

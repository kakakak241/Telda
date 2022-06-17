package com.example.demo.business_layer.interfaces;

import com.example.demo.data_access_layer.entity.Region;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Optional;

public interface RegionService {
    public List<Region> getAll();

    public List<Region> getAllByName(String name);

    public Optional<Region> getById(Long id);

    public void insert(Region region);

    public void update(Region region);

    public void delete(Region region);

    public void deleteById(Long id);

    public Long count();
}

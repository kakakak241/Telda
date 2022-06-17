package com.example.demo.business_layer;

import com.example.demo.business_layer.interfaces.RegionService;
import com.example.demo.data_access_layer.entity.Region;
import com.example.demo.data_access_layer.mapper.RegionMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionServiceImpl implements RegionService {
    private final RegionMapper regionMapper;

    public RegionServiceImpl(RegionMapper regionMapper){
        this.regionMapper = regionMapper;
    }

    @Cacheable(cacheNames = "regions")
    public List<Region> getAll() {
        return regionMapper.getAll();
    }

    @Cacheable(cacheNames = "region", key = "#name")
    public List<Region> getAllByName(String name) {
        return regionMapper.getAllByName(name);
    }

    @Cacheable(cacheNames = "region", key = "#id")
    public Optional<Region> getById(Long id) {
        return regionMapper.getById(id);
    }

    public void insert(Region region) {
        regionMapper.insert(region);
    }

    public void update(Region region) {
        regionMapper.update(region);
    }

    public void delete(Region region) {
        regionMapper.delete(region);
    }

    public void deleteById(Long id) {
        regionMapper.deleteById(id);
    }

    @Cacheable(cacheNames = "count")
    public Long count() {
        return regionMapper.count();
    }
}

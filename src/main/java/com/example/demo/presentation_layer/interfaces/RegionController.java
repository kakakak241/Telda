package com.example.demo.presentation_layer.interfaces;

import com.example.demo.data_access_layer.entity.Region;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RegionController {
    List<Region> getAll() throws InterruptedException;
    List<Region> getAllByName(String name) throws InterruptedException;
    Region getById(Long id);
    void insert(Region region) throws InterruptedException;
    void update(Region region) throws InterruptedException;
    void delete(Region region);
    void deleteById(Long id);
    Long count();
}

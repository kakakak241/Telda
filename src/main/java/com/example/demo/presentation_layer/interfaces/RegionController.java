package com.example.demo.presentation_layer.interfaces;

import com.example.demo.data_access_layer.entity.Region;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RegionController {
    List<Region> getAll();
    List<Region> getAllByName(String name);
    Region getById(Long id);
    Region getByNames(String name, String shortName);
    void insert(Region region);
    void update(Region region);
    void delete(Region region);
    void deleteById(Long id);
    Long count();
}

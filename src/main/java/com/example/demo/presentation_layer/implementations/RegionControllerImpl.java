package com.example.demo.presentation_layer.implementations;

import com.example.demo.business_layer.RegionServiceImpl;
import com.example.demo.business_layer.interfaces.RegionService;
import com.example.demo.data_access_layer.entity.Region;
import com.example.demo.presentation_layer.interfaces.RegionController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class RegionControllerImpl implements RegionController {
    private final RegionService regionService;

    public RegionControllerImpl(RegionServiceImpl regionServiceImpl){
        this.regionService = regionServiceImpl;
    }

    @GetMapping("/all")
    @Override
    public List<Region> getAll() {
        return regionService.getAll();
    }

    @GetMapping("/allByName/{name}")
    @Override
    public List<Region> getAllByName(@PathVariable("name") String name) {
        return regionService.getAllByName(name);
    }

    @GetMapping("/get/{id}")
    @Override
    public Region getById(@PathVariable("id") Long id) {
        try {
            return regionService.getById(id).orElseThrow();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add")
    @Override
    public void insert(@RequestBody Region region) {
        System.out.println(region.toString());
        regionService.insert(region);
    }

    @PatchMapping("/update")
    @Override
    public void update(@RequestBody Region region) {
        regionService.update(region);
    }

    @DeleteMapping("/delete")
    @Override
    public void delete(@RequestBody Region region) {
        regionService.delete(region);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public void deleteById(@PathVariable("id") Long id) {
        regionService.deleteById(id);
    }

    @GetMapping("/count")
    @Override
    public Long count() {
        return regionService.count();
    }
}
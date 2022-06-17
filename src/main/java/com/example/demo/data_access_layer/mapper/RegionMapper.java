package com.example.demo.data_access_layer.mapper;

import com.example.demo.data_access_layer.entity.Region;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Optional;

@Mapper
public interface RegionMapper {
    @Select("select * from region")
    List<Region> getAll();

    @Select("select * from region where name like #{name}")
    List<Region> getAllByName(@Param("name") String name);


    @Select("select * from region where id = #{id}")
    Optional<Region> getById(@Param("id") Long id);

    @Insert("insert into region (id, name, abbreviation) values (#{id}, #{name}, #{abbreviation})")
    void insert(Region region);


    @Update("update region set name = #{name}, abbreviation = #{abbreviation} where id = #{id}")
    void update(Region region);

    @Delete("delete from region where id = #{id}")
    void delete(Region region);

    @Delete("delete from region where id = #{id}")
    void deleteById(@Param("id") Long id);

    @Select("select count(*) from region")
    Long count();
}
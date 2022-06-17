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

    @Select("select * from region where name = #{name} and short_name = #{short_name}")
    Optional<Region> getByNames(@Param("name") String name,
                                @Param("short_name") String shortName);

    @Insert("insert into region (id, name, short_name) values (#{id}, #{name}, #{shortName})")
    void insert(Region region);


    @Update("update region set name = #{name}, short_name = #{shortName} where id = #{id}")
    void update(Region region);

    @Delete("delete from region where id = #{id}")
    void delete(Region region);

    @Delete("delete from region where id = #{id}")
    void deleteById(@Param("id") Long id);

    @Select("select count(*) from region")
    Long count();
}
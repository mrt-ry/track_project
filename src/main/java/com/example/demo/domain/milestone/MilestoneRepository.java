package com.example.demo.domain.milestone;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;



@Mapper
public interface MilestoneRepository {

    @Select("select * from milestones")
    List<MilestoneEntity> findAll();

    @Insert("insert into milestones (milestone, status,priority,date,category) values (#{milestone}, #{status},#{priority},#{date},#{category})")
    int insert(String milestone, String status,int priority,Date date,String category);

    @Select("select * from milestones where id = #{id}")
    MilestoneEntity findData(long id);

    @Delete("delete from milestones where id=#{id}")
    int deleteById(long id);

    // @Update("update milestones set milestone = #{milestone}")
    // int update(String milestone, String status,int priority,Date date,String category);
}

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

    @Insert("insert into milestones (milestone, status,priority,date,category,project) values (#{milestone}, #{status},#{priority},#{date},#{category},#{id})")
    int insert(String milestone, String status, int priority, Date date, String category, String id);

    @Select("select * from milestones where id = #{id}")
    MilestoneEntity findData(long id);

    @Delete("delete from milestones where id=#{id}")
    int deleteById(long id);

    @Update("update milestones set milestone = #{milestone}, status = #{status}, priority = #{priority}, date = #{date}, category = #{category} where id = #{id}")
    int update(long id, String milestone, String status, int priority, Date date, String category);

    @Select("select * from milestones where project = #{projectid} order by ${sortdata} ${sorttype}")
    List<MilestoneEntity> sort(String sortdata, String sorttype, String projectid);

    @Select("select * from projects")
    List<Project> findAllprojects();

    @Select("select * from milestones where project = #{id}")
    List<MilestoneEntity> findProject(String id);

    @Select("select name from projects where id = #{id}")
    String getProjectName(String id);

    @Select("select img from projects where id = #{id}")
    String getProjectimg(String id);

    @Select("select detail from projects where id = #{id}")
    String getProjectdetail(String id);

    @Select("select distinct category from milestones where project= #{id}")
    List<String> getMilestoneCategory(String id);

    @Select("select distinct status from milestones where project= #{id}")
    List<String> getMilestoneStatus(String id);
}

package com.example.demo.domain.milestone;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MilestoneRepository {
    @Select("select * from milestones")
    List<MilestoneEntity> findAll();

    @Insert("insert into milestones (milestone, description) values (#{milestone}, #{description})")
    int insert(String milestone, String description);

    @Select("select * from milestones where id = #{id}")
    MilestoneEntity findData(long id);
}

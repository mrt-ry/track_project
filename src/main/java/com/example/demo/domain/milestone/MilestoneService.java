package com.example.demo.domain.milestone;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MilestoneService {

    private final MilestoneRepository milestoneRepository;

    public List<MilestoneEntity> findAll() {
        return milestoneRepository.findAll(); 
    }

    public MilestoneEntity findData(long id) {
        return milestoneRepository.findData(id); 
    }
    
    public void create(String milestone, String status,int priority,Date date,String category) {
        milestoneRepository.insert(milestone, status,priority,date,category);
    }

     public void deleteById(long id) {
        milestoneRepository.deleteById(id); 
    }

    // public void update(String milestone, String status,int priority,Date date,String category) {
    //     milestoneRepository.update(milestone, status,priority,date,category);
    // }

}

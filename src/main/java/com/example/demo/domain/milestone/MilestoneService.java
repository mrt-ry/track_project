package com.example.demo.domain.milestone;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MilestoneService {

    private final MilestoneRepository milestoneRepository;

    public List<MilestoneEntity> findAll() {
        return milestoneRepository.findAll(); 
        // return List.of(
        //         new MilestoneEntity(1, "1", "1"),
        //         new MilestoneEntity(2, "2", "2"),
        //         new MilestoneEntity(3, "3", "3")
        // );
    }

    public MilestoneEntity findData(long id) {
        return milestoneRepository.findData(id); 
    }

    
    public void create(String milestone, String description) {
        milestoneRepository.insert(milestone, description);
        
    }

}

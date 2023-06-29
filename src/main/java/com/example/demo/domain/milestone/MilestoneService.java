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

    public void create(String milestone, String status, int priority, Date date, String category, String id) {
        milestoneRepository.insert(milestone, status, priority, date, category, id);
    }

    public void deleteById(long id) {
        milestoneRepository.deleteById(id);
    }

    public void update(long id, String milestone, String status, int priority, Date date, String category) {
        milestoneRepository.update(id, milestone, status, priority, date, category);
    }

    public List<MilestoneEntity> sort(String sortdata, String sorttype, String projectid) {
        return milestoneRepository.sort(sortdata, sorttype, projectid);
    }

    public List<Project> findAllprojects() {
        return milestoneRepository.findAllprojects();
    }

    public List<MilestoneEntity> findProject(String id) {

        return milestoneRepository.findProject(id);
    }

    public String getProjectName(String id) {

        return milestoneRepository.getProjectName(id);
    }

    public String getProjectimg(String id) {
        return milestoneRepository.getProjectimg(id);
    }

    public String getProjectdetail(String id) {
        return milestoneRepository.getProjectdetail(id);
    }

    public List<String> getMilestoneCategory(String id) {
        return milestoneRepository.getMilestoneCategory(id);
    }

    public List<String> getMilestoneStatus(String id) {
        return milestoneRepository.getMilestoneStatus(id);
    }
}
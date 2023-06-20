package com.example.demo.domain.milestone;

import java.util.List;

public class MilestoneService {
    public List<MilestoneEntity> findAll() {
        return List.of(
                new MilestoneEntity(1, "1", "1"),
                new MilestoneEntity(2, "2", "2"),
                new MilestoneEntity(3, "3", "3")
        );
    }
}

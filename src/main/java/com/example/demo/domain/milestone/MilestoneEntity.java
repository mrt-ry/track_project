package com.example.demo.domain.milestone;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MilestoneEntity {

    private long id;
    private String milestone;
    private String description;

}

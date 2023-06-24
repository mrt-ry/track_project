package com.example.demo.domain.milestone;

import java.sql.Date;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MilestoneEntity {

    private long id;
    private String milestone;
    private String status;
    private int priority;
    private Date date;
    private String category;

}

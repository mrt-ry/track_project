package com.example.demo.domain.milestone;

import java.sql.Date;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Project {

    private long id;
    private String name;
    private String detail;

}
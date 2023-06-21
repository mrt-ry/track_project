package com.example.demo.web.milestone;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@NotBlank
@Size(max=256)
@Validated MilestoneForm form
public class MilestoneForm {
    private String milestone;
    private String description;
}

package com.example.demo.web.milestone;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MilestoneForm {

    @NotBlank
    @Size(max=256)
    private String milestone;

    @NotBlank
    @Size(max=256)
    private String description;
}

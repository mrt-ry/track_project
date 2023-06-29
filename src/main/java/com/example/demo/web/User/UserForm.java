package com.example.demo.web.User;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserForm {

    @NotBlank
    @Size(max = 256)
    private String userName;

    @NotBlank
    @Size(max = 256)
    private String password;

    private String iamge;

}

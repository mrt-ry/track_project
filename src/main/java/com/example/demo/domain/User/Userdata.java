package com.example.demo.domain.User;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Userdata {

	private long id;
	private String userName;
	private String password;
	private String image;

}
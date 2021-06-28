package com.crossit.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Member {
	
	private Long id;
	private String email;
	private String password;
	private String nickname;
	private Long role;
	private Long career;
	private Long belonging;
	private String profile;
	private String introduction;
	private String portfolio;
	private String registerDate;

}

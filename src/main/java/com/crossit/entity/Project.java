package com.crossit.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

public class Project {

	private Long id;
	private String name;
	private int count;
	private String introduce;
	//DTO는 페이지별로 나누기 DB에 전송
	private Date limitdate;
	private int profile;
	private String hostorg;
	private String category;
	private String qualification;



}

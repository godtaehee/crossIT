package com.crossit.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor

public class Board {
	
	private int articleNum; //글번호
	private String title; //제목
	private String content; //콘텐츠
	private int hit; //조회수
	private int category; //카테고리
	private String secretYn; 
	private String deleteYn;
	private LocalDateTime registerDate;
	private LocalDateTime updateDate;
	private LocalDateTime deleteDate;
	private Integer memberId; //작성자의아이디 
	private String imgfileName; //이미지 파일 이름
	
	public Board() {
		
	}
	
	
	
	

}

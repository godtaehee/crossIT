package com.crossit.entity;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor

public class Board {
	
	private int id; //글번호
	private String title; //제목
	private String content; //콘텐츠
	private String writer;
	private int viewCount; //조회수
	private int category; // *카테고리
	private String secretYn; 
	private String deleteYn;
	private Date insertTime;
	private Date updateTime;
	private Date deleteTime;
	private LocalDateTime registerDate;
//
//	private Integer memberId; //작성자의아이디
//	private String imgfileName; //이미지 파일 이름
	
	public Board() {
		
	}
	
	
	
	

}

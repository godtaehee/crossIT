package com.crossit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileVo {
	
	private int imgFileNo; //이미지 파일 번호 
	private String imgFileName; //이미지 파일 이
	private int articleNum; //글 번호 (해당 글의 번호. board의ID ) 
	private String regDate; //등록 일자 
	

}

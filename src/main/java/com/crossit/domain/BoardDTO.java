package com.crossit.domain;



import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BoardDTO extends CommonDTO {

	/** 번호 (PK) */
	private Long id;

	/** 제목 */
	private String title;

	/** 내용 */
	private String content;

	/** 작성자 */
	private String writer;

	/** 작성자 프로필 */
	private String writerProfile;

	/** 조회 수 */
	private int viewCnt;

	/** 공지 여부 */
	private String noticeYn;

	/** 비밀 여부 */
	private String secretYn;

	/** 파일 변경 여부 */
	private String changeYn;

//	1: 자랑하기, 2: Today I learn, 3: 프로젝트 같이해요, 4:기타
	private int category;

	/** 파일 인덱스 리스트 */
	private List<Long> fileIdxs;

	private String thumbnail;

	private String insertTimeFormat;

}

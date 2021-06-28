package com.crossit.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDTO extends CommonDTO {

	private Long id;

	private Long boardId;

	private String content;

	private String writer;

}
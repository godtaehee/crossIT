package com.crossit.entity;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class reply {
	
	private Long id;
	private LocalDateTime registerDate;
	private LocalDateTime updateDate;
	private Long writerId;
	private Long boardId;

}

package com.crossit.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Follow {
	
	private Long id;
	private Long memberId;
	private Long follower;

}

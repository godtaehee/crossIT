package com.crossit.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {
	
	private Long id;
	private Long sender;
	private Long receiver;
}

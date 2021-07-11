package com.crossit.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Team {

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true)
	private String sender;

	@Column(unique = true)
	private String requestor;

	private String contact;

	private String message;

	int confirm;


}

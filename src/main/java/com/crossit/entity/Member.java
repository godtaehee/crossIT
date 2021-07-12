package com.crossit.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter @Setter @EqualsAndHashCode(of = "id")
@Builder @AllArgsConstructor @NoArgsConstructor
public class Member {

	@Id @GeneratedValue
	private Long id;

	@Column(unique = true)
	private String email;

	@Column(unique = true)
	private String nickname;

	private String password;

	private boolean emailVerified;

	private String emailCheckToken;


	// TODO 쿼리에 추가해야함
	private LocalDateTime emailCheckTokenGeneratedAt;

	private String introduction;

	private Long role;

	private Long job;

	private LocalDateTime joinedAt;

	private String contact;

	private String location;

	private String profileImage;

	@ColumnDefault("0")
	private int alarmCount;

	public void generateEmailCheckToken() {
		this.emailCheckToken = UUID.randomUUID().toString();
		this.emailCheckTokenGeneratedAt = LocalDateTime.now();
	}

	public void completeSignUp() {
		this.emailVerified = true;
		this.joinedAt = LocalDateTime.now();
	}

	public boolean isValidToken(String token) {
		return this.emailCheckToken.equals(token);
	}

	public boolean canSendConfirmEmail() {
		return this.emailCheckTokenGeneratedAt.isBefore(LocalDateTime.now().minusSeconds(10));
	}
}

package com.crossit.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter

public class IndexView extends Board{
	private String profile_img;
	private String nickname;

	public IndexView() {
		
	}

	public IndexView(int articleNum, String title, String content, int hit, int category, String secretYn,
			String deleteYn, LocalDateTime registerDate, LocalDateTime updateDate, LocalDateTime deleteDate,
			Integer memberId, String imgfileName , String profile_img, String nickname) {
		super(articleNum, title, content, hit, category, secretYn, deleteYn, registerDate, updateDate, deleteDate, memberId,
				imgfileName);
		this.profile_img = profile_img;
		this.nickname = nickname;
	}
	

	
	
	
	

} 
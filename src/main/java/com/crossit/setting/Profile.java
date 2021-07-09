package com.crossit.setting;

import com.crossit.entity.Member;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Profile {

	private String introduction;

	private String location;

	private String contact;

	public Profile(Member member) {
		this.introduction = member.getIntroduction();
		this.location = member.getLocation();
		this.contact = member.getContact();
	}
}

package com.crossit.setting;

import com.crossit.annotation.CurrentUser;
import com.crossit.entity.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SettingController {

	@GetMapping("/settings/profile")
	public String profileUpdatedForm(@CurrentUser Member member, Model model) {
		model.addAttribute(member);
		model.addAttribute(new Profile(member));

		return "settings/profile";
	}

//	@PostMapping("/settings/profile")
//	public String updateProfile(@CurrentUser Member member, @Valid)

}

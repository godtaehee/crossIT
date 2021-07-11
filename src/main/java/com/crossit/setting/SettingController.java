package com.crossit.setting;

import com.crossit.annotation.CurrentUser;
import com.crossit.entity.Member;
import com.crossit.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class SettingController {

	private static final String SETTINGS_PROFILE_VIEW_NAME = "settings/profile";
	private static final String SETTINGS_PROFILE_URL = "/settings/profile";

	private static final String SETTINGS_PASSWORD_VIEW_NAME = "settings/password";
	private static final String SETTINGS_PASSWORD_URL = "/settings/password";

	private final MemberService memberService;

	@GetMapping(SETTINGS_PROFILE_URL)
	public String profileUpdatedForm(@CurrentUser Member member, Model model) {
		model.addAttribute(member);
		model.addAttribute(new Profile(member));

		return SETTINGS_PROFILE_VIEW_NAME;
	}

	@PostMapping(SETTINGS_PROFILE_URL)
	public String updateProfile(@CurrentUser Member member, @Valid Profile profile, Errors errors,
								Model model, RedirectAttributes redirectAttributes) {
		if(errors.hasErrors()) {
			model.addAttribute(member);
			System.out.println("test");
			return SETTINGS_PROFILE_VIEW_NAME;
		}


		memberService.updateProfile(member, profile);
		redirectAttributes.addFlashAttribute("message", "프로필을 수정했습니다.");

		return "redirect:/admin/mylog/" + member.getNickname();

	}

//	@GetMapping(SETTINGS_PROFILE_URL)
//	public String passwordUpdateForm(@CurrentUser Member member, )

}

package com.crossit.controller;

import com.crossit.entity.SignUpForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class MemberController {

	@GetMapping("sign-up")
	public String signUp(Model model) {
		model.addAttribute(new SignUpForm());
		return "member/signup";
	}

	@PostMapping("/sign-up")
	public String signUpSubmit(@Valid SignUpForm signUpForm, Errors errors) {
		if (errors.hasErrors()) {
			return "member/signup";
		}

		return "redirect:/";
	}

}

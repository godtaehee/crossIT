package com.crossit.controller;


import com.crossit.annotation.CurrentUser;
import com.crossit.entity.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String home(@CurrentUser Member member, Model model) {
		if(member != null) {
		model.addAttribute(member);
		}

		return "index";
	}
}

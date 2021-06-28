package com.crossit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.crossit.entity.Member;
import com.crossit.service.MemberService;

@Controller
public class MemberController {


    @Autowired
    MemberService memberService;


    @Autowired
    PasswordEncoder passwordEncoder;

    //signup 회원가입. register에서 들어와서 member/signup html로 간다.
    @GetMapping("/register")
    public String getSignUpPage(Model model, Member member) {

        return "member/signup"; //html
    }

    @PostMapping("/register")
    public String signUp(@ModelAttribute Member member, Model model) {

        String inputPassword = member.getPassword();
        member.setPassword(passwordEncoder.encode(inputPassword));
        memberService.signUp(member);
        model.addAttribute("member", member);
        return "util/signUpComplete";

    }

    @GetMapping("/login")
    public String getSignInPage(Model model, Member member) {
        model.addAttribute("member", member);
        return "member/signin";
    }

//	@PostMapping("/login")
//	public String signIn(@ModelAttribute Member member, Model model) {
//		int result = memberService.signIn(member);
//
//		if(result == 1) {
//			return "util/signInComplete";
//		}
//		else {
//
//		}
//		return "util/signUpComplete";
//	}

}

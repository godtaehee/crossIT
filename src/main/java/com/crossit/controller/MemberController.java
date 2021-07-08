package com.crossit.controller;


import com.crossit.entity.Member;
import com.crossit.entity.SignUpForm;
import com.crossit.repository.MemberRepository;
import com.crossit.service.MemberService;
import com.crossit.validator.SignUpFormValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
@RequiredArgsConstructor
public class MemberController {


	@Autowired
	PasswordEncoder passwordEncoder;

	private final SignUpFormValidator signUpFormValidator;
	private final MemberService memberService;
	private final MemberRepository memberRepository;


	@InitBinder("signUpForm")
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(signUpFormValidator);
	}

	//signup 회원가입. register에서 들어와서 member/signup html로 간다.
	@GetMapping("/register")
	public String getSignUpPage(@ModelAttribute SignUpForm signUpForm) {
		return "member/signup"; //html
	}

	@PostMapping("/signup")
	public String signUp(@Valid SignUpForm signUpForm, Errors errors, HttpServletRequest req) {
		if (errors.hasErrors()) {
			return "member/signup";
		}

		Member member = memberService.processNewAccount(signUpForm);

		memberService.login(member,req);
		return "redirect:/";

	}


	@GetMapping("/login")
	public String getSignInPage(HttpServletRequest req) {
		String referer = req.getHeader("Referer");
		req.getSession().setAttribute("prevPage", referer);
		return "member/signin";
	}


	@GetMapping("/user/logout")
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
		return "redirect:/";
	}


	@GetMapping("/admin/myLog")
	public String post(Model model, HttpServletRequest req) {

		HttpSession session = req.getSession();
		Member member = (Member)session.getAttribute("member");
		model.addAttribute("member", member);
		return "admin/myLog";
	}


	@PostMapping("/admin/myLog")
	public String adminPage(Model model, Member member) {
		model.addAttribute("member", member);
		return "admin/myLog";
	}

	@GetMapping("/admin/edit")
	public String edit(Model model, Member member,HttpSession session){

		member=(Member)session.getAttribute("member");
		model.addAttribute("member", member);
		return "admin/edit";
	}

	@GetMapping("/admin/modify")
	public String edit(HttpServletRequest req, @ModelAttribute Member member, Model model ){

		model.addAttribute("member", member);

		return "admin/myLog";
	}


	@PostMapping ("/admin/modify")
	public String edit(HttpServletRequest req, @ModelAttribute Member member,HttpSession session, Model model ){

		Member newMember = (Member) session.getAttribute("member");

		newMember.setIntroduction(member.getIntroduction());
		newMember.setLocation(member.getLocation());
		newMember.setContact(member.getContact());

		memberService.memberUpdate(newMember);

		model.addAttribute("member", newMember);
		System.out.println("=======================================");
		System.out.println(newMember.getIntroduction());
		return "admin/myLog";
	}

	@GetMapping("/check-email-token")
	public String checkEmailToken(String token, String email, Model model, HttpServletRequest req) {
		Member member = memberRepository.findByEmail(email);
		String view = "member/checked-Email";
		if (member == null) {
			model.addAttribute("error", "wrongEmail" );
			return view;
		}

		if(!member.isValidToken(token)){
			model.addAttribute("error", "wrongEmail" );
			return view;

		}


		member.completeSignUp();
		memberService.login(member, req);

		model.addAttribute("numberOfUser", memberRepository.count());
		model.addAttribute("nickname", member.getNickname());
		return view;

	}
}

package com.crossit.controller;


import com.crossit.entity.SignUpForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.crossit.entity.Member;
import com.crossit.service.MemberService;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


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
    public String getSignInPage(HttpServletRequest req, Model model, Member member) {
        String referer = req.getHeader("Referer");
        req.getSession().setAttribute("prevPage",referer);
        model.addAttribute("member", member);
        System.out.println(referer);
        return "member/signin";
    }


    @GetMapping("/user/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/";
    }



    @GetMapping("/admin/myLog")
    public String post(Model model , Member member){
        model.addAttribute("member",member);
        return "admin/myLog";
    }


    @PostMapping("/admin/myLog")
    public String adminPage(Model model, Member member){
        model.addAttribute("member",member);
        return "admin/myLog";
    }
}

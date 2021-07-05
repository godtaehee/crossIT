package com.crossit.configuration;

import com.crossit.entity.Member;
import com.crossit.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;

import java.io.IOException;

public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {


    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,Authentication authentication)throws ServletException, IOException {


        //세션에 담아야 할 것 : 회원의 프로필 이미지 경로
        //Member 엔티티를 @Autowired 해주면 될까? <-질문임


        HttpSession session = request.getSession();

        if (session != null) {
            String redirectUrl = (String) session.getAttribute("prevPage");


            //session.setAttribute("nickname" , authentication.getName());


            System.out.println("--------세션에 담긴 회원의 닉네임----------");
            System.out.println(authentication.getName());
            System.out.println("------------------------------");

            if (redirectUrl != null) {
                session.removeAttribute("prevPage");
                getRedirectStrategy().sendRedirect(request, response, redirectUrl);
            } else {
                super.onAuthenticationSuccess(request, response, authentication);
            }
        } else {
            super.onAuthenticationSuccess(request, response, authentication);
        }


    }
}

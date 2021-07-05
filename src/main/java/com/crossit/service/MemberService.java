package com.crossit.service;

import com.crossit.entity.Member;
import com.crossit.entity.SignUpForm;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {

    public int signUp(SignUpForm signUpForm);
    public int getMember(Member member);
    public int signIn(Member member);
    public int updateMypage(Member member);

	Member processNewAccount(SignUpForm signUpForm);

	void login(Member member);
}

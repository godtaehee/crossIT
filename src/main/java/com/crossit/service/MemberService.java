package com.crossit.service;

import com.crossit.entity.Member;
import com.crossit.entity.SignUpForm;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {

    public int signUp(SignUpForm signUpForm);
    public int getMember(Member member);
    public int signIn(Member member);

    public Member findMemberByNickName(String nickName);

	Member processNewAccount(SignUpForm signUpForm);

	void login(Member member);

	//회원 정보 수정
	public void memberUpdate (Member member);
}

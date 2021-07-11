package com.crossit.dao;

import com.crossit.entity.SignUpForm;
import org.apache.ibatis.annotations.Mapper;

import com.crossit.entity.Member;

@Mapper
public interface MemberDao {

	int signUp(SignUpForm signUpForm);

	int findMemberById(Long id);

	int findMemberByEmail(String email);

	int signIn(Member member);

	Member findMemberByNickName(String nickName);

	void memberUpdate(Member member);

}

package com.crossit.dao;

import com.crossit.entity.SignUpForm;
import org.apache.ibatis.annotations.Mapper;

import com.crossit.entity.Member;

@Mapper
public interface MemberDao {

	public int signUp(SignUpForm signUpForm);

	public int findMemberById(Long id);

	public int findMemberByEmail(String email);

	public int signIn(Member member);

	public Member findMemberByNickName(String nickName);

	public void memberUpdate (Member member);

}

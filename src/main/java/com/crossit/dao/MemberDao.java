package com.crossit.dao;

import org.apache.ibatis.annotations.Mapper;

import com.crossit.entity.Member;

@Mapper
public interface MemberDao {
	
	public int signUp(Member member);
	
	public int findMemberById(Long id);
	
	public int findMemberByEmail(String email);
	
	public int signIn(Member member);

}

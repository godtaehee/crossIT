package com.crossit.service;

import com.crossit.entity.Member;

public interface MemberService {

    public int signUp(Member member);
    public int getMember(Member member);
    public int signIn(Member member);
    public int updateMypage(Member member);

}

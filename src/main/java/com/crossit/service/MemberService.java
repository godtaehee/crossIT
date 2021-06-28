package com.crossit.service;

import com.crossit.entity.Member;

public interface MemberService {

    public int signUp(Member member);
    public int getMember(Long id);
    public int signIn(Member member);

}

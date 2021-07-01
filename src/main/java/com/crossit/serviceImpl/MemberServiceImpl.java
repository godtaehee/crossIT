package com.crossit.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crossit.dao.MemberDao;
import com.crossit.entity.Member;
import com.crossit.service.MemberService;

import javax.transaction.Transactional;

@Service("MemberService")
public class MemberServiceImpl implements MemberService{

    @Autowired
    MemberDao memberDao;

    @Override
    public int signUp(Member member) {

        int result = memberDao.findMemberByEmail(member.getEmail());

        if(result > 0) {
            return -1;
        }else {
            return memberDao.signUp(member);
        }
    }

    @Override
    public int signIn(Member member) {

        System.out.println("로그인 라ㅓㅘㅓㅘㅓㅘㅘㅓㅘㅓㅘㅓㅘ성공");
        int result = memberDao.signIn(member);

        if(result > 0) {
            System.out.println("로그인 성공");

        }

        return result;

    }

    @Override
    public int updateMypage(Member member) {

        int result = memberDao.updateMypage(member);

        if(result > 0){
            return -1;
        }

        return 1;
    }

    @Override
    public int getMember(Member member) {
       int result = memberDao.findMemberById(member.getId());
        return 0;
    }



}

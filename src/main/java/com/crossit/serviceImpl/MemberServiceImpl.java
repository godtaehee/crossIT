package com.crossit.serviceImpl;

import com.crossit.dao.MemberDao;
import com.crossit.entity.Member;
import com.crossit.entity.SignUpForm;
import com.crossit.repository.MemberRepository;
import com.crossit.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao memberDao;
	private final PasswordEncoder passwordEncoder;

	private final MemberRepository memberRepository;
	private final JavaMailSender javaMailSender;

	@Override
	public int signUp(SignUpForm signUpForm) {

		int result = memberDao.findMemberByEmail(signUpForm.getEmail());

		if (result > 0) {
			return -1;
		} else {
			return memberDao.signUp(signUpForm);
		}
	}

	@Override
	public int getMember(Member member) {
		return 0;
	}

	@Override
	public int signIn(Member member) {

		System.out.println("로그인 라ㅓㅘㅓㅘㅓㅘㅘㅓㅘㅓㅘㅓㅘ성공");
		int result = memberDao.signIn(member);

		if (result > 0) {
			System.out.println("로그인 성공");

		}

		return result;

	}


	@Override
	public Member findMemberByNickName(String nickName) {
		Member member = memberDao.findMemberByNickName(nickName);
		System.out.println("-------------ss-----------------");
		System.out.println(member.getNickname());
		System.out.println("------------------------------");
		return member;
	}



	@Override
	@Transactional
	public Member processNewAccount(SignUpForm signUpForm) {
		Member newMember = saveNewAccount(signUpForm);

		newMember.generateEmailCheckToken();

		sendSignUpConfirmEmail(newMember);
		return newMember;
	}

	@Override
	public void login(Member member) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
			member.getNickname(),
			member.getPassword(),
			List.of(new SimpleGrantedAuthority("ROLE_USER")));
		SecurityContext context = SecurityContextHolder.getContext();
		context.setAuthentication(token);
	}


/*-----------*/
	@Override
	public void memberUpdate(Member member) {

	memberDao.memberUpdate(member);

	}
/*-----------*/


	private Member saveNewAccount(SignUpForm signUpForm) {
		Member member = Member.builder()
			.nickname(signUpForm.getNickname())
			.email(signUpForm.getEmail())
			.password(passwordEncoder.encode(signUpForm.getPassword()))
			.job((long) signUpForm.getJob())
			.build();

		Member newMember = memberRepository.save(member);
		System.out.println(newMember.getPassword());
		return newMember;
	}

	private void sendSignUpConfirmEmail(Member newMember) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(newMember.getEmail());
		simpleMailMessage.setSubject("CrossIt, 회원 가입 인증메일 입니다.");
		simpleMailMessage.setText("/check-email-token?token=" + newMember.getEmailCheckToken() +
			"&email=" + newMember.getEmail());
		javaMailSender.send(simpleMailMessage);
	}


}

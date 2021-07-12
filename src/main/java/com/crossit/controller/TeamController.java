package com.crossit.controller;


import com.crossit.annotation.CurrentUser;
import com.crossit.entity.Member;
import com.crossit.entity.Team;
import com.crossit.repository.MemberRepository;
import com.crossit.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class TeamController {

	private final TeamRepository teamRepository;

	private final MemberRepository memberRepository;

	@PostMapping("/request-team/{sender}")
	public String requestTeam(@CurrentUser Member member, Team team, @PathVariable String sender) {

		Member senderMember = memberRepository.findByNickname(sender);
		System.out.println(senderMember.getAlarmCount());
		senderMember.setAlarmCount(senderMember.getAlarmCount() + 1);
		team.setRequestor(member.getNickname());
		memberRepository.save(senderMember);
		teamRepository.save(team);

		return "redirect:/";
	}




}

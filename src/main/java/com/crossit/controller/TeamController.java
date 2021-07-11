package com.crossit.controller;


import com.crossit.annotation.CurrentUser;
import com.crossit.entity.Member;
import com.crossit.entity.Team;
import com.crossit.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class TeamController {

	private final TeamRepository teamRepository;

	@PostMapping("/request-team")
	public String requestTeam(@CurrentUser Member member, Team team) {

		team.setRequestor(member.getNickname());
		teamRepository.save(team);

		return "redirect:/";
	}




}

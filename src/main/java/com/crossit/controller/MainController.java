package com.crossit.controller;


import com.crossit.annotation.CurrentUser;
import com.crossit.domain.BoardDTO;
import com.crossit.entity.Member;
import com.crossit.entity.Team;
import com.crossit.repository.MemberRepository;
import com.crossit.service.BoardService;
import com.crossit.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

	@Autowired
	private BoardService boardService;

	@Autowired
	private TeamService teamService;

	final private MemberRepository memberRepository;


	@GetMapping("/")
	public String home(@CurrentUser Member member, Model model) {
		if(member != null) {
			model.addAttribute("current", member);
		}

		List<BoardDTO> boardList = boardService.getList();

		model.addAttribute("boardList", boardList);

		return "index";
	}

	@GetMapping("/alarm/test")
	@ResponseBody
	public List<Team> alarmtest() {

		List<Team> team = teamService.getMyTeamRequestList("abc123");

		return team;
	}

	@GetMapping("/alarm")
	public String alarm(@CurrentUser Member member, Model model) {
		if(member != null) {
			model.addAttribute("current", member);
		}

		List<Team> team = teamService.getMyTeamRequestList(member.getNickname());

		model.addAttribute("teamList", team);

		return "alarm/alarm-list";
	}

	@PostMapping("/alarm/delete/{id}")
	@ResponseBody
	public List<Team> alarmDelete(@CurrentUser Member member, Model model, @PathVariable int id) {
		if(member != null) {
			model.addAttribute("current", member);
		}


		member.setAlarmCount(member.getAlarmCount() - 1);
		memberRepository.save(member);
		teamService.deleteTeamRequest(id);
		List<Team> team = teamService.getMyTeamRequestList(member.getNickname());

		return team;
	}

}

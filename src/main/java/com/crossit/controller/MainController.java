package com.crossit.controller;


import com.crossit.annotation.CurrentUser;
import com.crossit.domain.BoardDTO;
import com.crossit.entity.Member;
import com.crossit.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

	@Autowired
	private BoardService boardService;

	@GetMapping("/")
	public String home(@CurrentUser Member member, Model model) {
		if(member != null) {
		model.addAttribute(member);
		}

		List<BoardDTO> boardList = boardService.getList();
		model.addAttribute("boardList", boardList);

		return "index";
	}

}

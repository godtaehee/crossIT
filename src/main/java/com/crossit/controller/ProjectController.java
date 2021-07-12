package com.crossit.controller;

import com.crossit.entity.Project;
import com.crossit.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/project/")
public class ProjectController {
	@Autowired
	ProjectService service;

	@GetMapping("index")
	public String index(Model model) {

		model.addAttribute("project",new Project());

		return "createProject/list";
	}


	@GetMapping("makeproject")
	public String makeProject(Model model) { //Model은 담는애!!!

		Project project = new Project();
		model.addAttribute("project", project);

		return "createProject/makeProject";
	}
	@PostMapping("makeproject")
	public String makeProject (@ModelAttribute Project project) {
		//DB에서 조작하는 과정.
		service.insert(project);
		return "createProject/createProjectIndex";
	}


	@GetMapping("createprojectindex")
	public String createProjectIndex(Model model) { //Model은 담는애!!!

		Project project = new Project();
		model.addAttribute("project", project);

		return "createProject/createProjectIndex";
	}
	@PostMapping("createprojectindex")
	public String creatProjectIndex (@ModelAttribute Project project) {
		//DB에서 조작하는 과정.
		service.insert(project);
		return "createProject/createProject";
	}


	@GetMapping("createproject")
	public String createProject(Model model) { //Model은 담는애!!!

		Project project = new Project();
		model.addAttribute("project", project);

		return "createProject/createProject";
	}

	@PostMapping("createproject")
	public String createProject (@ModelAttribute Project project) {
		//DB에서 조작하는 과정.
		service.insert(project);
		return "createProject/myProject";
	}


	//"redirect:myproject?id="+??회원의+프로젝트(어떤페이지를 만들어야 하나?)??.getList();
//	@GetMapping("myproject")
//	public String myproject(Model model) {
//		필요한 것: 그 회원의 ID, 가 등록한 프로젝트들.
//		왼쪽은 html자리. 오른쪽은 html에 들어갈 text. 근데 이걸 DB에서 가져와야
//		model.addAttribute("hostorg", "<>hostorg<>");
//		model.addAttribute("limitdate", limitdate);
//		model.addAttribute("category", category);
//		model.addAttribute("qualification", qualification);
//		model.addAttribute("awards", awards);
//
//		return "createProject/myproject";
//	}
//
	@RequestMapping("del")
	public String del(int id) {

		service.delete(id);

		return "redirect:myproject"; //??createProject/myproject로??
	}



}

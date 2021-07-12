package com.crossit.controller;

import com.crossit.annotation.CurrentUser;
import com.crossit.entity.Member;
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
	public String makeProject(Model model) {

		Project project = new Project();
		model.addAttribute("project", project);

		return "createProject/makeProject";
	}
	@PostMapping("makeproject")
	public String makeProject (@CurrentUser Member member, @ModelAttribute Project project) {
		//DB에서 조작하는 과정.
		service.insert(project);
		return "createProject/createProjectIndex";
	}

	@GetMapping("dashboard")
	public String dashboard(@CurrentUser Member member, @ModelAttribute Project project) {

//		int projectId = service.getProjectId();
//		int memberId = user.getId;
//		service.insertMyProject(projectId, memberId);

		return "createProject/dashboard";
	}


	@GetMapping("createprojectindex")
	public String createProjectIndex(Model model) {

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
	public String createProject(Model model) {

		Project project = new Project();
		model.addAttribute("project", project);

		return "createProject/createProject";
	}

	@PostMapping("createproject")
	public String createProject (@ModelAttribute Project project) {

		service.insert(project);
		return "createProject/myProject";
	}


	@RequestMapping("del")
	public String del(int id) {

		service.delete(id);

		return "redirect:myproject"; //??createProject/myproject로??
	}



}

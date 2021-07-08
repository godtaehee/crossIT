package com.crossit.service;

import java.util.List;

import com.crossit.entity.Project;

public interface ProjectService {

	List<Project> getList();
	
	Project get(int id);
	int insert(Project project);
	int delete(int id);
	
	int insertmore(Project project);

}

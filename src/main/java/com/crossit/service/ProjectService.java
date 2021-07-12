package com.crossit.service;

import com.crossit.entity.Project;

import java.util.List;

public interface ProjectService {

	List<Project> getList();

	Project get(int id);
	int insert(Project project);
	int delete(int id);
	int getProjectId(int projectId);

}

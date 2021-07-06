package com.crossit.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crossit.dao.ProjectDao;
import com.crossit.entity.Project;
import com.crossit.service.ProjectService;

@Service
public class ProjectServiceImp implements ProjectService {
@Autowired 
	private ProjectDao dao;

	@Override
	public Project get(int id) {

		return (Project) dao.get(id);
	}

	@Override
	public int insert(Project project) {
		
		return dao.insert(project);
	}

	@Override
	public int insertmore(Project project) {
		// TODO Auto-generated method stub
		return dao.insert(project);
	}
	
	@Override
	public List<Project> getList() {
		List<Project> list = dao.getList();
		return list;
	}

	@Override
	public int delete(int id) {
		
		return dao.delete(id);
	}





}

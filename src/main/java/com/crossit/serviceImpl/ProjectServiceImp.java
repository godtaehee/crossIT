package com.crossit.serviceImpl;

import com.crossit.dao.ProjectDao;
import com.crossit.entity.Project;
import com.crossit.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
	public int insertMore(Project project) {

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

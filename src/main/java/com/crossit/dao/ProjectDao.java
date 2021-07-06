package com.crossit.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.crossit.entity.Project;

@Mapper
public interface ProjectDao {//interface는 내가 구현할 함수 목록만 갖고 있어야

		//CRUD중 R만 List고 나머지 셋은 성공했냐안했냐 이므로 0이나 1을 반환.

		ProjectDao get(int id);

		List<Project> getList();
		int insert(Project project);
		int update(Project project);
		int delete(int id);
		
		int insertmore(Project project);
}

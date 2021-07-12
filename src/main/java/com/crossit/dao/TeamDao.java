package com.crossit.dao;

import com.crossit.entity.Team;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeamDao {

	int getMyTeamRequest(String nickname);

	List<Team> getMyTeamRequestList(String nickname);

}



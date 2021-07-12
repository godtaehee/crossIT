package com.crossit.service;

import com.crossit.entity.Team;

import java.util.List;

public interface TeamService {


	int getMyTeamRequest(String nickname);

	List<Team> getMyTeamRequestList(String nickname);

	int deleteTeamRequest(int id);


}

package com.crossit.serviceImpl;

import com.crossit.dao.TeamDao;
import com.crossit.entity.Team;
import com.crossit.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImp implements TeamService {

	@Autowired
	TeamDao teamDao;

	@Override
	public int getMyTeamRequest(String nickname) {
		return teamDao.getMyTeamRequest(nickname);
	}

	@Override
	public List<Team> getMyTeamRequestList(String nickname) {
		return teamDao.getMyTeamRequestList(nickname);
	}
}

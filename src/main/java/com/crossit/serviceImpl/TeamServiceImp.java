package com.crossit.serviceImpl;

import com.crossit.dao.TeamDao;
import com.crossit.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImp implements TeamService {

	@Autowired
	TeamDao teamDao;

	@Override
	public int getMyTeamRequest(String nickname) {
		return teamDao.getMyTeamRequest(nickname);
	}
}

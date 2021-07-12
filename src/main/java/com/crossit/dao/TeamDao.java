package com.crossit.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeamDao {

	int getMyTeamRequest(String nickname);

}



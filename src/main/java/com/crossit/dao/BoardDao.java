package com.crossit.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.crossit.domain.BoardDTO;
import com.crossit.paging.Criteria;


@Mapper
public interface BoardDao {

	public int insertBoard(BoardDTO params);

	public BoardDTO selectBoardDetail(Long idx);

	public int updateBoard(BoardDTO params);

	public int deleteBoard(Long idx);

	public List<BoardDTO> selectBoardList(BoardDTO params);

	public Long selectBoardTotalCount(BoardDTO params);
	
	

}

	

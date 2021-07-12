package com.crossit.dao;

import com.crossit.domain.BoardDTO;
import com.crossit.view.BoardListViewByJob;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardDao {

	int insertBoard(BoardDTO params);

	BoardDTO selectBoardDetail(Long idx);

	int updateBoard(BoardDTO params);

	int deleteBoard(Long idx);

	List<BoardDTO> selectBoardList(BoardDTO params);

	Long selectBoardTotalCount(BoardDTO params);

	List<BoardDTO> getList();

	List<BoardListViewByJob> getListByJob();

	List<BoardDTO> getBoardListByNickname(String nickname);



}



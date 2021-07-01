package com.crossit;

import com.crossit.dao.BoardDao;
import com.crossit.domain.BoardDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CrossitApplicationTests {

	@Autowired
	BoardDao boardDao;

	@Test
	void selectBoard() {
		BoardDTO boardDTO = boardDao.selectBoardDetail((long) 2046);
		System.out.println(boardDTO);
	}

	@Test
	void getBoardList() {
		BoardDTO params = new BoardDTO();
		List<BoardDTO> boardDTO = boardDao.selectBoardList(params);
		System.out.println(boardDTO);
	}

}

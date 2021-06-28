package com.crossit.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.crossit.domain.BoardDTO;
import com.crossit.domain.FileDTO;

public interface BoardService {

	public boolean registerBoard(BoardDTO params);
	
	public boolean registerBoard(BoardDTO params, MultipartFile[] files);

	public BoardDTO getBoardDetail(Long idx);

	public boolean deleteBoard(Long idx);

	public List<BoardDTO> getBoardList(BoardDTO boardDTO);
	
	public List<FileDTO> getAttachFileList(Long boardId);

}
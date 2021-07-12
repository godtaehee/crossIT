package com.crossit.service;

import com.crossit.domain.BoardDTO;
import com.crossit.domain.FileDTO;
import com.crossit.view.BoardListViewByJob;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BoardService {

    boolean registerBoard(BoardDTO params);

    boolean registerBoard(BoardDTO params, MultipartFile[] files);

    BoardDTO getBoardDetail(Long idx);

    boolean deleteBoard(Long idx);

    List<BoardDTO> getBoardList(BoardDTO boardDTO);

    List<FileDTO> getAttachFileList(Long boardId);

    List<BoardDTO> getList();

	List<BoardDTO> getBoardListByNickname(String nickname);

	List<BoardListViewByJob> getListByJob();
}

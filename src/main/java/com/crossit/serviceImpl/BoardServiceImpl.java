package com.crossit.serviceImpl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import com.crossit.dao.BoardDao;
import com.crossit.dao.FileDao;
import com.crossit.domain.BoardDTO;
import com.crossit.domain.FileDTO;
import com.crossit.paging.PaginationInfo;
import com.crossit.service.BoardService;
import com.crossit.util.FileUtils;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;

	@Autowired
	private FileDao fileDao;

	@Autowired
	private FileUtils fileUtils;



	@Override
	public boolean registerBoard(BoardDTO params) {

		int queryResult = 0;

		if (params.getId() == null) {
			queryResult = boardDao.insertBoard(params);
		} else {
			queryResult = boardDao.updateBoard(params);

			// 파일이 추가, 삭제, 변경된 경우
			if ("Y".equals(params.getChangeYn())) {
				fileDao.deleteAttach(params.getId());

				// fileIdxs에 포함된 idx를 가지는 파일의 삭제여부를 'N'으로 업데이트
				if (CollectionUtils.isEmpty(params.getFileIdxs()) == false) {
					fileDao.undeleteAttach(params.getFileIdxs());
				}
			}
		}

		return (queryResult > 0);
	}

	@Override
	public boolean registerBoard(BoardDTO params, MultipartFile[] files) {

		int queryResult = 1;

		if (registerBoard(params) == false) {
			return false;
		}

		List<FileDTO> fileList = fileUtils.uploadFiles(files, params.getId());
		if (CollectionUtils.isEmpty(fileList) == false) {
			queryResult = fileDao.insertAttach(fileList);
			if (queryResult < 1) {
				queryResult = 0;
			}
		}

		return (queryResult > 0);
	}

	@Override
	public BoardDTO getBoardDetail(Long idx) {
		return boardDao.selectBoardDetail(idx);
	}

	@Override
	public boolean deleteBoard(Long id) {
		long queryResult = 0;

		BoardDTO board = boardDao.selectBoardDetail(id);

		if (board != null && "N".equals(board.getDeleteYn())) {
			queryResult = boardDao.deleteBoard(id);
		}

		return (queryResult == 1) ? true : false;
	}

	@Override
	public List<BoardDTO> getBoardList(BoardDTO boardDTO) {
		List<BoardDTO> boardList = Collections.emptyList();

		long boardTotalCount = boardDao.selectBoardTotalCount(boardDTO);


		PaginationInfo paginationInfo = new PaginationInfo(boardDTO);
		paginationInfo.setTotalRecordCount(boardTotalCount);

		boardDTO.setPaginationInfo(paginationInfo);

		if (boardTotalCount > 0) {
			boardList = boardDao.selectBoardList(boardDTO);
		}

		return boardList;
	}

	@Override
	public List<FileDTO> getAttachFileList(Long boardId) {

		int fileTotalCount = fileDao.selectAttachTotalCount(boardId);
		if (fileTotalCount < 1) {
			return Collections.emptyList();
		}
		return fileDao.selectAttachList(boardId);
	}

}

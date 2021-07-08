package com.crossit.controller;

import com.crossit.constant.Method;
import com.crossit.domain.BoardDTO;
import com.crossit.domain.FileDTO;
import com.crossit.service.BoardService;
import com.crossit.util.UiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller
public class BoardController extends UiUtils {

	@Autowired
	private BoardService boardService;

	@GetMapping("/board/write")
	public String openBoardWrite(@ModelAttribute("params") BoardDTO params, @RequestParam(value = "id", required = false) Long id, Model model, Principal principal) {
		if (id == null) {
			BoardDTO boardDTO = new BoardDTO();
			boardDTO.setWriter(principal.getName());
			model.addAttribute("board", boardDTO);
		} else {
			BoardDTO board = boardService.getBoardDetail(id);
			if (board == null || "Y".equals(board.getDeleteYn())) {
				return showMessageWithRedirect("없는 게시글이거나 이미 삭제된 게시글입니다.", "/board/list", Method.GET, null, model);
			}
			model.addAttribute("board", board);

			List<FileDTO> fileList = boardService.getAttachFileList(id);
			model.addAttribute("fileList", fileList);
		}

		return "board/write";
	}

	@PostMapping(value = "/board/register")
	public String registerBoard(final BoardDTO params, final MultipartFile[] files, Model model) {
		Map<String, Object> pagingParams = getPagingParams(params);
		try {
			boolean isRegistered = boardService.registerBoard(params, files);
			if (isRegistered == false) {
				return showMessageWithRedirect("게시글 등록에 실패하였습니다.", "/board/list", Method.GET, pagingParams, model);
			}
		} catch (DataAccessException e) {
			return showMessageWithRedirect("데이터베이스 처리 과정에 문제가 발생하였습니다.", "/board/list", Method.GET, pagingParams, model);

		} catch (Exception e) {
			return showMessageWithRedirect("시스템에 문제가 발생하였습니다.", "/board/list", Method.GET, pagingParams, model);
		}

		return showMessageWithRedirect("게시글 등록이 완료되었습니다.", "/admin/myLog", Method.GET, pagingParams, model);
	}


	@GetMapping("/board/list")
	public String openBoardList(@ModelAttribute("params") BoardDTO params, Model model) {
		List<BoardDTO> boardList = boardService.getBoardList(params);
		model.addAttribute("boardList", boardList);

		return "board/list";
	}

	@GetMapping("/board/test")
	@ResponseBody
	public List<BoardDTO> getBoardList(@ModelAttribute("params") BoardDTO params) {
		List<BoardDTO> boardList = boardService.getList();
		return boardList;
	}


	@GetMapping(value = "/board/view")
	public String openBoardDetail(@ModelAttribute("params") BoardDTO params, @RequestParam(value = "id", required = false) Long id, Model model) {
		if (id == null) {
			return showMessageWithRedirect("올바르지 않은 접근입니다.", "/board/list", Method.GET, null, model);
		}

		BoardDTO board = boardService.getBoardDetail(id);
		if (board == null || "Y".equals(board.getDeleteYn())) {
			return showMessageWithRedirect("없는 게시글이거나 이미 삭제된 게시글입니다.", "/board/list", Method.GET, null, model);
		}
		model.addAttribute("board", board);

		List<FileDTO> fileList = boardService.getAttachFileList(id); // 추가된 로직
		model.addAttribute("fileList", fileList); // 추가된 로직

		return "board/view";
	}

	@PostMapping("/board/delete")
	public String deleteBoard(@ModelAttribute("params") BoardDTO params, @RequestParam(value = "id", required = false) Long id, Model model) {
		if (id == null) {
			return showMessageWithRedirect("올바르지 않은 접근입니다.", "/board/list", Method.GET, null, model);
		}

		Map<String, Object> pagingParams = getPagingParams(params);
		try {
			boolean isDeleted = boardService.deleteBoard(id);
			if (isDeleted == false) {
				return showMessageWithRedirect("게시글 삭제에 실패하였습니다.", "/board/list", Method.GET, pagingParams, model);
			}
		} catch (DataAccessException e) {
			return showMessageWithRedirect("데이터베이스 처리 과정에 문제가 발생하였습니다.", "/board/list", Method.GET, pagingParams, model);

		} catch (Exception e) {
			return showMessageWithRedirect("시스템에 문제가 발생하였습니다.", "/board/list", Method.GET, pagingParams, model);
		}

		return showMessageWithRedirect("게시글 삭제가 완료되었습니다.", "/board/list", Method.GET, pagingParams, model);
	}


	@RequestMapping("/")
	public String list(Model model) {
		List<BoardDTO> list = boardService.getList();
		model.addAttribute("list", list);

		return "index";


	}
}
